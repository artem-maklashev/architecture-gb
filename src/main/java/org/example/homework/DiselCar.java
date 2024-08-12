package org.example.homework;

import org.example.Car;
import org.example.FuelType;
import org.example.Fueling;
import org.example.Refueling;

import java.awt.*;

public class DiselCar extends Car implements Refueling, Fueling, Wash {
    public DiselCar(String trademark, String model, Color color) {
        super(trademark, model, color);
        this.fuelType = FuelType.DIESEL;
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

    @Override
    public void fuel() {
        System.out.println("Заправка дизельным топливом - " + getTrademark() + " " + getModel());
        setRefuelingStation(null);
    }

    @Override
    public void refuel(FuelType fuelType) {
        if (refuelingStation != null) {
            if (refuelingStation.getFuelTypes().contains(this.fuelType)) {
                if (fuelType != this.fuelType) {
                    throw new IllegalArgumentException("Неправильный тип топлива");
                } else {
                    fuel(); //заправка дизелем
                }
            } else {
                System.out.println("Нет топлива. Выберите другую заправку. - " + getTrademark() + " " + getModel());
            }
        } else {
            System.out.println("Нет заправки. - " + getTrademark() + " " + getModel());
        }
        setRefuelingStation(null);
    }

    @Override
    public void interiorCleaning() {
        System.out.println("Чистка салона дизельного автомобиля");
    }

    @Override
    public void exteriorCleaning() {
        System.out.println("Чистка кузова дизельного автомобиля");
    }

    @Override
    public void polishing() {
        System.out.println("Полировка кузова дизельного автомобиля");
    }
}
