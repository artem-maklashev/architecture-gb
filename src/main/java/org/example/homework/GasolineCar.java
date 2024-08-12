package org.example.homework;

import org.example.Car;
import org.example.FuelType;
import org.example.Fueling;
import org.example.Refueling;

import java.awt.*;

public class GasolineCar extends Car implements Refueling, Fueling {
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

    public GasolineCar(String trademark, String model, Color color) {
        super(trademark, model, color);
        this.fuelType = FuelType.GASOLINE;
    }

    @Override
    public void fuel() {
        System.out.println("Заправка бензином- " + getTrademark() + " " + getModel());
    }

    @Override
    public void refuel(FuelType fuelType) {
        if (refuelingStation != null) {
            if (refuelingStation.getFuelTypes().contains(this.fuelType)) {
                if (fuelType != this.fuelType) {
                    throw new IllegalArgumentException("Неправильный тип топлива");
                } else {
                    fuel(); //заправка бензином
                }
            } else {
                System.out.println("Нет топлива. Выберите другую заправку - " + getTrademark() + " " + getModel());
            }
        } else {
            System.out.println("Нет заправок - " + getTrademark() + " " + getModel());
        }
        setRefuelingStation(null);
    }
}
