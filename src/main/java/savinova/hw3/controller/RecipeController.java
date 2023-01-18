package savinova.hw3.controller;
import org.springframework.web.bind.annotation.*;
import savinova.hw3.model.Recipe;
import savinova.hw3.service.RecipeService;


@RestController
@RequestMapping("/recipe")
    public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @PostMapping
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        return recipeService.add(recipe);
    }

    @GetMapping("/{id}")
    public Recipe getRecipe(@PathVariable("id") int id) {
        return recipeService.get(id);
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@PathVariable("id") int id, @RequestBody Recipe recipe) {
        return recipeService.update(id, recipe);
    }

    @DeleteMapping("/{id}")
    public Recipe deleteRecipe(@PathVariable("id") int id) {
        return recipeService.remove(id);
    }
}


