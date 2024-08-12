package org.example;

import org.example.homework.DiselCar;
import org.example.homework.GasolineCar;
import org.example.homework.WashingStation;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        DiselCar car = new DiselCar("Diesel", "modelDiesel", Color.BLACK );
        GasolineCar car2 = new GasolineCar("Gasoline", "modelGasoline", Color.BLUE );

        RefuelingStation fuelingStation = new RefuelingStation();
        fuelingStation.getFuelTypes().add(FuelType.DIESEL);
        fuelingStation.getFuelTypes().add(FuelType.GASOLINE);

        car.setRefuelingStation(fuelingStation);
        car.refuel(FuelType.DIESEL);

        car2.refuel(FuelType.GASOLINE);
        car2.setRefuelingStation(fuelingStation);
        car2.refuel(FuelType.GASOLINE);

        WashingStation washingStation = new WashingStation();
        car.setWashingStation(washingStation);
        car.interiorCleaning();

    }

    public static double calculateMaintenance(Car car) {
        if (car.getWheelsCount() == 6){
            return 1500*6;
        } else {
            return 1000*4;
        }
    }
}
