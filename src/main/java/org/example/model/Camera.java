package org.example.model;

public class Camera {
    private Point3D location;
    private Angle3D angel;

    public Camera(Point3D location, Angle3D angel) {
        this.location = location;
        this.angel = angel;
    }

    public void rotate(Angle3D angle) {
        this.angel = angle;
        System.out.println("Поворот камеры");
    }

    public void move(Point3D point) {
        this.location = point;
        System.out.println("Перемещение камеры");
    }
}
