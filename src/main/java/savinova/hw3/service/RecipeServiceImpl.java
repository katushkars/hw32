package savinova.hw3.service;

import org.springframework.stereotype.Service;
import savinova.hw3.model.Recipe;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final Map<Integer, Recipe> recipeMap = new HashMap<>();
    private int counter=0;

    @Override
    public Recipe add(Recipe recipe) {
        recipeMap.put(this.counter++, recipe);
        return recipeMap.put(this.counter++, recipe);
    }

    @Override
    public Recipe get(int id) {
        return recipeMap.get(id);
    }
    @Override
    public Recipe update (int id,Recipe recipe){
        if(recipeMap.containsKey(id)){
            return recipeMap.put(id,recipe);
        }
        return null;
    }
    @Override
    public Recipe remove (int id){
        return recipeMap.remove(id);
    }


}
