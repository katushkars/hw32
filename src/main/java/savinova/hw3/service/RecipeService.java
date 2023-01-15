package savinova.hw3.service;
import org.springframework.stereotype.Service;
import savinova.hw3.model.Recipe;


public interface RecipeService {
Recipe add(Recipe recipe);
Recipe get (int id);

}
