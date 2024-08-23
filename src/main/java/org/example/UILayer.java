package org.example;

public interface UILayer {
    void openProject(String name);
    void showProjectSettings();
    void saveProject();
    void printAllModels();
    void printAllTextures();
    void renderAll();
    void renderModel(int index);
}
