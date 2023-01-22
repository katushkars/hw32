package savinova.hw3.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import savinova.hw3.service.IngredientFileService;
import savinova.hw3.service.RecipeFileService;

import java.io.*;

@RestController
@RequestMapping("/file")
@Tag(name = "Работа с файлами")
public class FileController {
    private final RecipeFileService recipeFileService;
    private final IngredientFileService ingredientFileService;

    public FileController(RecipeFileService recipeFileService, IngredientFileService ingredientFileService) {
        this.recipeFileService = recipeFileService;
        this.ingredientFileService = ingredientFileService;
    }
    @GetMapping("/export")
    @Operation(summary = "Экспорт")
    public ResponseEntity<InputStreamResource> dowloadDataFile() throws FileNotFoundException {
        File file = recipeFileService.getDataFile();
        if (file.exists()) {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .contentLength(file.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"RecipeFileLog.json\"")
                    .body(resource);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

        @PostMapping(value = "/import/recipe", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
        @Operation(summary = "Импорт рецептов")
                public ResponseEntity<Void> uploadDataFileRecipe (@RequestParam MultipartFile file){
            recipeFileService.cleanDataFile();
            File dataFile = recipeFileService.getDataFile();
            try(FileOutputStream fos = new FileOutputStream(dataFile)){
                IOUtils.copy(file.getInputStream(), fos);
                return ResponseEntity.ok().build();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    @PostMapping(value = "/import/ingredient", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Импорт ингредиентов")
    public ResponseEntity<Void> uploadDataFileIngredient (@RequestParam MultipartFile file){
        ingredientFileService.cleanDataFile();
        File dataFile = ingredientFileService.getDataFile();
        try(FileOutputStream fos = new FileOutputStream(dataFile)){
            IOUtils.copy(file.getInputStream(), fos);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    }

