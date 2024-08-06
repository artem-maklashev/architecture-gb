package org.example.inmempry;

import org.example.model.Camera;
import org.example.model.Flash;
import org.example.model.PoligonalModel;
import org.example.model.Scene;

import java.util.ArrayList;
import java.util.List;

public class ModelStore implements IModelChanger {
    private List<IModelChangedObserver> observers = new ArrayList<>();
    private List<PoligonalModel> models ;
    ;
    private List<Scene> scenes ;
    private List<Flash> flashes ;
    private List<Camera> cameras ;

    public ModelStore(List<PoligonalModel> models, List<Scene> scenes, List<Flash> flashes, List<Camera> cameras) {
        this.models = new ArrayList<>(models);
        this.scenes = new ArrayList<>(scenes);
        this.flashes = new ArrayList<>(flashes);
        this.cameras = new ArrayList<>(cameras);
    }

    public Scene getScene(int id) {
        return scenes.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void notifyChange() {
        observers.forEach(IModelChangedObserver::applyUpdateModel);
    }

    @Override
    public void registerModelChanger(IModelChangedObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterModelChanger(IModelChangedObserver observer) {
        observers.remove(observer);
    }

    public void addPoligonalModel(PoligonalModel model) {
        this.models.add(model);
        notifyChange();
    }
}
