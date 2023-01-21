package savinova.hw3.controller;
import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import savinova.hw3.model.Recipe;
import savinova.hw3.service.RecipeService;


@RestController
@RequestMapping("/recipe")
@Tag(name="Рецепты", description = "Работа с рецептами")
    public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @PostMapping
    @Operation(
            summary = "Добавить рецепт ",
            description = "Введите рецепт"

    )
    public ResponseEntity<?> addRecipe(@RequestBody Recipe recipe) {
        if (StringUtils.isBlank(recipe.getName())) {
            return ResponseEntity.badRequest().body("Добавьте название рецепта");
        }
        return ResponseEntity.ok(recipeService.add(recipe));
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Получить рецепт по id",
            description = "Введите id рецепта, чтобы получить его"

    )
    public Recipe getRecipe(@PathVariable("id") int id) {
        return recipeService.get(id);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Изменить рецепт по id",
            description = "Введите id рецепта, чтобы изменить его"

    )
    public Recipe updateRecipe(@PathVariable("id") int id, @RequestBody Recipe recipe) {
        return recipeService.update(id, recipe);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Удалить рецепт по id",
            description = "Введите id рецепта, чтобы удалить его"

    )
    public Recipe deleteRecipe(@PathVariable("id") int id) {
        return recipeService.remove(id);
    }
}


