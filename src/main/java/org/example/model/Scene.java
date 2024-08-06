package org.example.model;

import java.util.List;

public class Scene {
    private static int counter = 5000;
    private int id;
    private List<PoligonalModel> models;
    private List<Flash> flashes;
    private List<Camera> cameras;

    {
        id = ++counter;
    }

    public Scene(List<PoligonalModel> models, List<Flash> flashes, List<Camera> cameras) {
        this.models = models;
        this.flashes = flashes;
        this.cameras = cameras;
    }

    public Scene( List<PoligonalModel> models, List<Camera> cameras) {
        this.models = models;
        this.cameras = cameras;
    }

    public int getId() {
        return id;
    }

    public <T> T method1(T t) {
        return t;
    }

    public <T, U> T method2(T t, U u) {
        return t;
    }

    @Override
    public String toString() {
        return "Scene{" +
                "id=" + id +
                ", models=" + models +
                ", flashes=" + flashes +
                ", cameras=" + cameras +
                '}';
    }
}
