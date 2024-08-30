package ru.artemmaklashev.seminar9homework.repository;

import lombok.Data;
import org.springframework.stereotype.Repository;
import ru.artemmaklashev.seminar9homework.model.WeatherForecast;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Repository
public class WeatherRepository {

    private List<WeatherForecast> forecasts = new ArrayList<>();

    public List<WeatherForecast> getWeather(LocalDate start, LocalDate end) {
        List<WeatherForecast> result = new ArrayList<>();
        for (WeatherForecast forecast : forecasts) {
            if (forecast.getDate().isAfter(start) && forecast.getDate().isBefore(end)) {
                result.add(forecast);
            }
        }
        return result;
    }

    public WeatherForecast saveWeather(WeatherForecast weatherForecast) {
        forecasts.add(weatherForecast);
        return weatherForecast;
    }

    public WeatherForecast updateWeather(String date, int temperatureCelsius) {
        WeatherForecast forecast = forecasts.stream()
                .filter(f -> f.getDate().toString().equals(date))
                .findFirst()
                .orElse(null);
        if (forecast != null) {
            forecast.setTemperatureCelsius(temperatureCelsius);
        }
        return forecast;
    }

    public WeatherForecast deleteWeather(String date) {
        WeatherForecast forecast = forecasts.stream()
                .filter(f -> f.getDate().toString().equals(date))
                .findFirst()
                .orElse(null);
        if (forecast != null) {
            forecasts.remove(forecast);
        }
        return forecast;
    }
}
