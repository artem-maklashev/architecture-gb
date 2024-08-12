package org.example;

import org.example.homework.WashingStation;

import java.awt.*;

public abstract class Car {
    private final String trademark;
    private final String model;
    private final Color color;
    protected CarType type;
    private int wheelsCount;
    protected FuelType fuelType;
    private GearboxType gearboxType;
    private double engineCapacity;
    private boolean fogLights = false;

    protected RefuelingStation refuelingStation;
    protected WashingStation washingStation;

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
        return wheelsCount;    }

    public String getTrademark() {
        return trademark;
    }

    public String getModel() {
        return model;
    }

    public Color getColor() {
        return color;
    }

    public void setRefuelingStation(RefuelingStation refuelingStation) {
        this.refuelingStation = refuelingStation;
    }

    public void setWashingStation(WashingStation washingStation) {
        this.washingStation = washingStation;
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
