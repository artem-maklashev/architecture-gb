package org.example;

import java.awt.*;

public class FlyCar extends Car {
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

    public FlyCar(String trademark, String model, Color color) {
        super(trademark, model, color);
        setWheelsCount(4);
    }
}
