package savinova.hw3.service;

import org.springframework.stereotype.Service;
import savinova.hw3.model.Ingredient;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final Map<Integer, Ingredient> ingredientMap = new HashMap<>();
    private int counter = 0;


    @Override
    public Ingredient add(Ingredient ingredient) {
        ingredientMap.put(this.counter++, ingredient);
        return ingredientMap.put(this.counter++, ingredient);
    }

    @Override
    public Ingredient get(int id) {
        return ingredientMap.get(id);
    }

    @Override
    public Ingredient update(int id, Ingredient ingredient) {
        if (ingredientMap.containsKey(id)) {
            return ingredientMap.put(id, ingredient);
        }
        return null;
    }

    @Override
    public Ingredient remove(int id) {
        return ingredientMap.remove(id);
    }
}

