package org.example.model;

public class Flash {
    private Point3D location;
    private Angle3D angle;
    private Color color;
    private Float power;

    public Flash(Point3D location, Angle3D angle, Color color, Float power) {
        this.location = location;
        this.angle = angle;
        this.color = color;
        this.power = power;
    }


     public void rotate(Angle3D angle) {
        this.angle = angle;
         System.out.println("Поворот светильника");
     }

     public void move(Point3D point) {
        this.location = point;
         System.out.println("Перемещение светильника");
     }
}
