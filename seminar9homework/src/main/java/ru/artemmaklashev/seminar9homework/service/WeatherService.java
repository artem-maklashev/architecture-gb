package ru.artemmaklashev.seminar9homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.artemmaklashev.seminar9homework.model.WeatherForecast;
import ru.artemmaklashev.seminar9homework.repository.WeatherRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class WeatherService {
    private final WeatherRepository weatherRepository;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public List<WeatherForecast> getWeather(LocalDate startDate, LocalDate endDate) {
        return weatherRepository.getWeather(startDate, endDate);
    }

    public WeatherForecast saveWeather(WeatherForecast weatherForecast) {
        return weatherRepository.saveWeather(weatherForecast);
    }

    public WeatherForecast updateWeather(String date, int temperatureCelsius) {
        return weatherRepository.updateWeather(date, temperatureCelsius);
    }

    public WeatherForecast deleteWeather(String date) {
        return weatherRepository.deleteWeather(date);
    }
}
