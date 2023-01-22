package savinova.hw3.service;

import org.springframework.stereotype.Service;

import java.io.File;

public interface RecipeFileService {
    public boolean saveToFile(String json);
    public String readFromFile();

    boolean cleanDataFile();

    File getDataFile();
}
