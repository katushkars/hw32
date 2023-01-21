package savinova.hw3.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import savinova.hw3.model.Recipe;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeServiceImpl implements RecipeService {
    final RecipeFileService recipeFileService;
    private Map<Integer, Recipe> recipeMap = new HashMap<>();
    private int counter = 0;

    public RecipeServiceImpl(RecipeFileService recipeFileService) {
        this.recipeFileService = recipeFileService;
    }
    @PostConstruct
    private void init(){
        readToFile();

    }
    @Override
    public Recipe add(Recipe recipe) {
        recipeMap.put(this.counter++, recipe);
        saveToFile();
        return recipeMap.put(this.counter++, recipe);
    }

    @Override
    public Recipe get(int id) {
        return recipeMap.get(id);
    }

    @Override
    public Recipe update(int id, Recipe recipe) {
        if (recipeMap.containsKey(id)) {
            saveToFile();
            return recipeMap.put(id, recipe);
        }
        return null;
    }

    @Override
    public Recipe remove(int id) {
        return recipeMap.remove(id);
    }

    private void saveToFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(recipeMap);
            recipeFileService.saveToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    private void readToFile(){
        try {String json=recipeFileService.readFromFile();
            recipeMap=new ObjectMapper().readValue(json, new TypeReference<HashMap<Integer, Recipe>>(){});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
