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
   public Recipe addRecipe(Recipe recipe){

return recipeService.add (recipe);
   }
   @GetMapping("/{id}")
   public Recipe getRecipe(@PathVariable("id") int id){
        return recipeService.get(id);
   }


}
