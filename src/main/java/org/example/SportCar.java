package org.example;

import java.awt.*;

public class SportCar extends Car {

    public SportCar(String trademark, String model, Color color) {
        super(trademark, model, color);
        setWheelsCount(3);
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



}
