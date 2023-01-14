package savinova.hw3.service;

import org.springframework.stereotype.Service;
import savinova.hw3.model.Ingredient;
import savinova.hw3.model.Recipe;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final Map<Integer, Ingredient> ingredientMap = new HashMap<>();
    private int counter=0;


    @Override
    public Ingredient add(Ingredient ingredient) {
        ingredientMap.put(this.counter++, ingredient);
        return null;
    }

    @Override
    public Ingredient get(int id) {
        return ingredientMap.get(id);
    }
}

