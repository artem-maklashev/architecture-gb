package org.example;

import java.util.ArrayList;

public class Editor3D implements UILayer {
    private ProjectFile file;
    private BusinessLogicLayer buisinessLayer;
    private DatabaseAccess databaseAccessLayer;
    private Database database;


    private void initialize() {
        database = new EditorDatabase(file);
        databaseAccessLayer = new EditorDatabaseAccess(database);
        buisinessLayer = new EditorBusinessLogicalLayer(databaseAccessLayer);

    }

    @Override
    public void openProject(String name) {
        file = new ProjectFile(name);
        initialize();
    }

    @Override
    public void showProjectSettings() {
        checkProjectFile();

        System.out.println("*** Project ***");
        System.out.println("***************");
        System.out.println("Project name: " + file.getFileName());
        System.out.println("setting1: " + file.getSetting1());
        System.out.println("setting2: " + file.getSetting2());
        System.out.println("setting3: " + file.isSetting3());
    }

    private void checkProjectFile() {
        if (file == null) {
            throw new RuntimeException("No project file loaded");
        }
    }

    @Override
    public void saveProject() {
        database.save();
        System.out.println("Project saved");
    }


    @Override
    public void printAllModels() {
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>) buisinessLayer.getAllModels();
        for (int i = 0; i < models.size(); i++) {
            System.out.printf("===%d===", i);
            System.out.println(models.get(i));
            for (Texture texture : models.get(i).getTextures()) {
                System.out.printf("\t%s\n", texture);
            }
        }
    }

    @Override
    public void printAllTextures() {
        checkProjectFile();

        ArrayList<Texture> textures = (ArrayList<Texture>) buisinessLayer.getAllTextures();
        for (int i = 0; i < textures.size(); i++) {
            System.out.printf("===%d===", i);
            System.out.println(textures.get(i));
        }
    }

    @Override
    public void renderAll() {
        checkProjectFile();

        System.out.println("Подождите...");
        long startTime = System.currentTimeMillis();
        buisinessLayer.renderAllModels();
        long endTime = System.currentTimeMillis();
        System.out.printf("Операция выполнена за %d миллисекунд", endTime - startTime);
    }

    @Override
    public void renderModel(int index) {
        checkProjectFile();
        ArrayList<Model3D> models = (ArrayList<Model3D>) buisinessLayer.getAllModels();
        if (index < 0 || index > models.size() - 1) {
            throw new RuntimeException("Неверный индекс модели");
        }
        System.out.println("Подождте...");
        long startTime = System.currentTimeMillis();
        buisinessLayer.renderModel(models.get(index));
        long endTime = System.currentTimeMillis();
        System.out.printf("Операция выполнена за %d миллисекунд", endTime - startTime);
    }
}
