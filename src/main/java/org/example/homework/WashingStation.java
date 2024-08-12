package org.example.homework;

public class WashingStation implements Wash{
    @Override
    public void interiorCleaning() {
        System.out.println("Чистка салона");
    }

    @Override
    public void exteriorCleaning() {
        System.out.println("Мойка кузова");
    }

    @Override
    public void polishing() {
        System.out.println("Полировка");
    }
}
