package savinova.hw3.service;

import org.springframework.stereotype.Service;
import savinova.hw3.model.Ingredient;


public interface IngredientService {
    Ingredient add(Ingredient ingredient);
    Ingredient get (int id);
}