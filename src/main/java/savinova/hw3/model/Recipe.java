package savinova.hw3.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class Recipe {
    private String name;
    private int time;
    private List<Ingredient> ingredients;
    private List<String> steps;


}
