package savinova.hw3.controller;

import org.springframework.web.bind.annotation.*;
import savinova.hw3.model.Ingredient;
import savinova.hw3.model.Recipe;
import savinova.hw3.service.IngredientService;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    public Ingredient addIngredient(Ingredient ingredient) {
        return ingredientService.add(ingredient);
    }

    @GetMapping("/{id}")
    public Ingredient getIngredient(@PathVariable("id") int id) {
        return ingredientService.get(id);

    }
}
