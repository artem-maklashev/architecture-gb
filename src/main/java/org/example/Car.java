package org.example;

import java.awt.*;

public abstract class Car {
    private String trademark;
    private String model;
    private Color color;//TODO
    protected CarType type;
    private int wheelsCount;
    protected FuelType fuelType;
    private GearboxType gearboxType;
    private double engineCapacity;
    private boolean fogLights = false;

    //region Public Methods:
    public abstract void move();
    public abstract void maintenance();
    public abstract boolean gearShifting();
    public abstract boolean switchHeadLights();
    public abstract boolean switchWipers();
    public boolean switchFogLights(){
        fogLights =!fogLights;
        return fogLights;
    }
    protected void setWheelsCount(int wheelsCount){
        this.wheelsCount = wheelsCount;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }
    //endregion

    //region Constructors:

    public Car(String trademark, String model, Color color) {
        this.trademark = trademark;
        this.model = model;
        this.color = color;
    }

    //endregion
}
