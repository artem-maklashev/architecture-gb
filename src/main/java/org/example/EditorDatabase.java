package org.example;

import java.util.*;

public class EditorDatabase implements Database{
    private Random random = new Random();
    private final ProjectFile projectFile;
    private Collection<Entity> entities;

    public EditorDatabase(ProjectFile projectFile) {
        this.projectFile = projectFile;
        load();
    }

    @Override
    public void load() {
        //TODO: Загрузка данных
    }

    @Override
    public void save() {
        //TODO: сохранить данные
    }

    @Override
    public Collection<Entity> getAll() {
        if (entities == null) {
            entities = new ArrayList<>();
            int entCount = random.nextInt(5, 11);
            for (int i = 0; i < entCount; i++) {
                generateModelAndTexture();
            }
        }
        return entities;
    }

    private void generateModelAndTexture(){
        Model3D model = new Model3D();
        int txCount = random.nextInt(3);
        for (int i = 0; i < txCount; i++) {
            Texture texture = new Texture();
            model.getTextures().add(texture);
        }
        entities.add(model);
    }


}
