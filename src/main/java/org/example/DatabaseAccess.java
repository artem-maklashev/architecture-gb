package org.example;

import java.util.Collection;

public interface DatabaseAccess {
    void addEntity(Entity entity);
    void removeEntity(Entity entity);
    Collection<Texture> getAllTextures();
    Collection<Model3D> getAllModels();
}
