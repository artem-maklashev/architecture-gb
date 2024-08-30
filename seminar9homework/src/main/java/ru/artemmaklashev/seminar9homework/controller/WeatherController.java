package ru.artemmaklashev.seminar9homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.artemmaklashev.seminar9homework.model.WeatherForecast;
import ru.artemmaklashev.seminar9homework.service.WeatherService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public ResponseEntity<List<WeatherForecast>> getWeather(
            @RequestParam(name = "start_date") String start_date,
            @RequestParam(name = "end_date") String end_date
    ) {
        LocalDate start = LocalDate.parse(start_date);
        LocalDate end = LocalDate.parse(end_date);
        return ResponseEntity.ok(weatherService.getWeather(start, end));
    }

    @PostMapping("/weather")
    public ResponseEntity<WeatherForecast> addWeather(
            @RequestParam(name = "date") String date,
            @RequestParam(name = "temperatureCelsius") int temperatureCelsius
    ) {
        LocalDate localDate = LocalDate.parse(date);
        WeatherForecast weatherForecast = new WeatherForecast(localDate, temperatureCelsius);
        WeatherForecast result = weatherService.saveWeather(weatherForecast);

        return ResponseEntity.ok(weatherForecast);
    }

    @PutMapping("/weather")
    public ResponseEntity<WeatherForecast> updateWeather(
            @RequestParam(name = "date") String date,
            @RequestParam(name = "temperatureCelsius") int temperatureCelsius
    ) {
        LocalDate localDate = LocalDate.parse(date);

        WeatherForecast result = weatherService.updateWeather(date, temperatureCelsius);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/weather")
    public ResponseEntity<WeatherForecast> deleteWeather(@RequestParam("date") String date) {
        WeatherForecast result = weatherService.deleteWeather(date);

        return ResponseEntity.ok(result);
    }
}
