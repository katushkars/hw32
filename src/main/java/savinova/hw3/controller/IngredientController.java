package savinova.hw3.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import savinova.hw3.model.Ingredient;
import savinova.hw3.model.Recipe;
import savinova.hw3.service.IngredientService;

@RestController
@RequestMapping("/ingredient")
@Tag(name="Ингредиенты", description = "Работа с ингредиентами")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    @Operation(
            summary = "Добавить ингредиент ",
            description = "Введите ингредиент"

    )
    public ResponseEntity<Ingredient> addIngredient(@RequestBody Ingredient ingredient) {
        if (StringUtils.isEmpty(ingredient.getName())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ingredientService.add(ingredient));
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Получить ингредиент по id",
            description = "Введите id ингредиента, чтобы получить его"

    )
    public Ingredient getIngredient(@PathVariable("id") int id) {
        return ingredientService.get(id);

    }
    @PutMapping("/{id}")
    @Operation(
            summary = "Изменить ингредиент по id",
            description = "Введите id ингредиента, чтобы изменить его"

    )
    public Ingredient updateIngredient(@PathVariable("id") int id, @RequestBody Ingredient ingredient) {
        return ingredientService.update(id, ingredient);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Удалить ингредиент по id",
            description = "Введите id ингредиента, чтобы удалить его"

    )
    public Ingredient deleteIngredient(@PathVariable("id") int id) {
        return ingredientService.remove(id);
    }
}
