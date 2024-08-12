package org.example;

import java.util.ArrayList;
import java.util.List;

public class RefuelingStation implements Refueling{

    private List<FuelType> fuelTypes;

    public RefuelingStation() {
        this.fuelTypes = new ArrayList<>();
    }

    public List<FuelType> getFuelTypes() {
        return fuelTypes;
    }

    public void setFuelTypes(List<FuelType> fuelTypes) {
        this.fuelTypes = fuelTypes;
    }

    @Override
    public void refuel(FuelType fuelType) {
        switch (fuelType) {
            case DIESEL -> System.out.println("Заправка дизелем");
            case ELECTRIC -> System.out.println("Зарядка");
            case HYBRID -> System.out.println("Заправка бензином");
            case GASOLINE -> System.out.println("Заправка газом");
        }
    }
}
