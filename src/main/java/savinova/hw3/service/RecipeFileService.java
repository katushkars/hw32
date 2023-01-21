package savinova.hw3.service;

import org.springframework.stereotype.Service;

public interface RecipeFileService {
    public boolean saveToFile(String json);
    public String readFromFile();
}
