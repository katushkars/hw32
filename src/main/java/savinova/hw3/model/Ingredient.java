package savinova.hw3.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Ingredient {
    private String name;
    private int counter;
    private String unit;

}
