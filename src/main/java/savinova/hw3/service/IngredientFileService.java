package savinova.hw3.service;

import java.io.File;

public interface IngredientFileService {
    public boolean saveToFile(String json);
    public String readFromFile();

    abstract boolean cleanDataFile();

    File getDataFile();
}
