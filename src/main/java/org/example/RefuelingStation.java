package org.example;

public class RefuelingStation implements Refueling{
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
