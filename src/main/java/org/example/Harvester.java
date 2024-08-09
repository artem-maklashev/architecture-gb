package org.example;

import java.awt.*;

public class Harvester extends Car{
    public Harvester(String trademark, String model, Color color) {
        super(trademark, model, color);
    }

    @Override
    public void move() {

    }

    @Override
    public void maintenance() {

    }

    @Override
    public boolean gearShifting() {
        return false;
    }

    @Override
    public boolean switchHeadLights() {
        return false;
    }

    @Override
    public boolean switchWipers() {
        return false;
    }

    public void sweeping() {
        System.out.println("Автомобиль подметает улицу");
    }
}
