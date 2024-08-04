package org.example.model;

public class Flash {
    private Point3D location;
    private Angle3D angel;
    private Color color;
    private Float power;

    public Flash(Point3D location, Angle3D angel, Color color, Float power) {
        this.location = location;
        this.angel = angel;
        this.color = color;
        this.power = power;
    }
     public void rotate(Angle3D angle) {

     }

     public void move(Point3D point) {}
}
