package com.lukasdev.weather_forecast.controller;

import com.lukasdev.weather_forecast.model.WeatherData;
import com.lukasdev.weather_forecast.service.LocationService;
import com.lukasdev.weather_forecast.service.WeatherForecastService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/weather-forecast")
public class WeatherForecastController {

    private final LocationService locationService;

    private final WeatherForecastService weatherForecastService;

    public WeatherForecastController(LocationService locationService, WeatherForecastService weatherForecastService) {
        this.locationService = locationService;
        this.weatherForecastService = weatherForecastService;
    }

    @GetMapping("/{cep}")
    public ResponseEntity<WeatherData> getWeatherForecastByCep(@PathVariable(name = "cep") String cep,
                                                               @RequestParam(value = "forecast-days", required = false) Integer forecastDays) {

        forecastDays = forecastDays == null ? 1 : forecastDays;

        var locationData = this.locationService.getLocationCoordinates(cep);
        var weatherData = this.weatherForecastService.getWeatherDataForecast(locationData.lat(), locationData.lng(), forecastDays);
        return ResponseEntity.ok(weatherData);
    }
}
