package savinova.hw3.model;

import lombok.Data;

import java.util.List;
@Data
public class Recipe {
    private String name;
    private int time;
    private List<Ingredient> ingredients;
    private List<String> steps;


}
