package org.example.model;

import java.util.List;

public class Poligon {

    private List<Point3D> points;

    public Poligon(List<Point3D> points) {
        this.points = points;
    }

    public List<Point3D> getPoints() {
        return points;
    }

    public void setPoints(List<Point3D> points) {
        this.points = points;
    }
}
