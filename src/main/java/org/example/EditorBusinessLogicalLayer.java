package org.example;

import java.util.Collection;
import java.util.Random;

public class EditorBusinessLogicalLayer implements BusinessLogicLayer{
    private Random random = new Random();
    private DatabaseAccess db;

    public EditorBusinessLogicalLayer(DatabaseAccess db) {
        this.db = db;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        return db.getAllModels();
    }

    @Override
    public Collection<Texture> getAllTextures() {
        return db.getAllTextures();
    }

    @Override
    public void renderAllModels() {
        for (Model3D model : getAllModels()) {
            renderModel(model);
        }
    }

    @Override
    public void renderModel(Model3D model) {
        processRender(model);
    }

    private void processRender(Model3D model) {
        try {
            Thread.sleep(2500 - random.nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
