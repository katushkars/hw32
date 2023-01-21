package savinova.hw3.service;

public interface IngredientFileService {
    public boolean saveToFile(String json);
    public String readFromFile();
}
