package savinova.hw3.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import savinova.hw3.model.Ingredient;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientServiceImpl implements IngredientService {
    final IngredientFileService ingredientFileService;
    private Map<Integer, Ingredient> ingredientMap = new HashMap<>();
    private int counter = 0;

    public IngredientServiceImpl(IngredientFileService ingredientFileService) {
        this.ingredientFileService = ingredientFileService;
    }

    @PostConstruct
    public void init(){
        readToFile();
    }

    @Override
    public Ingredient add(Ingredient ingredient) {
        ingredientMap.put(this.counter++, ingredient);
        saveToFile();
        return ingredientMap.put(this.counter++, ingredient);
    }

    @Override
    public Ingredient get(int id) {
        return ingredientMap.get(id);
    }

    @Override
    public Ingredient update(int id, Ingredient ingredient) {
        if (ingredientMap.containsKey(id)) {
            saveToFile();
            return ingredientMap.put(id, ingredient);
        }
        return null;
    }

    @Override
    public Ingredient remove(int id) {
        return ingredientMap.remove(id);
    }
    private void saveToFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(ingredientMap);
            ingredientFileService.saveToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    private void readToFile(){
        try {String json=ingredientFileService.readFromFile();
            ingredientMap=new ObjectMapper().readValue(json, new TypeReference<HashMap<Integer, Ingredient>>(){});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

