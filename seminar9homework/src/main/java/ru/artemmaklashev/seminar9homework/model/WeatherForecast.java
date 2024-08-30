package ru.artemmaklashev.seminar9homework.model;

import lombok.Data;

import java.time.LocalDate;
@Data
public class WeatherForecast {
    private LocalDate date;
    private int temperatureCelsius;
    private int temperatureFahrenheit;

    public WeatherForecast(LocalDate date, int temperatureCelsius) {
        this.date = date;
        this.temperatureCelsius = temperatureCelsius;
        this.temperatureFahrenheit = setTemperatureFahrenheit(temperatureCelsius);
    }

    private int setTemperatureFahrenheit(int temperatureFahrenheit) {
        return temperatureCelsius*9/5+32; //преобразование температуры в Фаренгейт
    }
}
