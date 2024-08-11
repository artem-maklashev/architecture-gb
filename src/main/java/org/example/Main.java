package org.example;

public class Main {
    public static void main(String[] args) {

    }

    public static double calculateMaintenance(Car car) {
        if (car.getWheelsCount() == 6){
            return 1500*6;
        } else {
            return 1000*4;
        }
    }
}
