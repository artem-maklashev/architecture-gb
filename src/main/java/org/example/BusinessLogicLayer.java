package org.example;

import java.util.Collection;

public interface BusinessLogicLayer {
    Collection<Model3D> getAllModels();
    Collection<Texture> getAllTextures();
    void renderAllModels();
    void renderModel(Model3D model);

}
