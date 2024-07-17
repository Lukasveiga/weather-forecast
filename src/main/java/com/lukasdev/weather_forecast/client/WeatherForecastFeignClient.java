package com.lukasdev.weather_forecast.client;

import com.lukasdev.weather_forecast.config.FeignConfig;
import com.lukasdev.weather_forecast.model.WeatherData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weatherForecast", url = "${url.weather-forecast}", configuration = FeignConfig.class)
public interface WeatherForecastFeignClient {

    @GetMapping(value = "/forecast", consumes = MediaType.APPLICATION_JSON_VALUE)
    WeatherData getWeatherData(
            @RequestParam(name = "current") String current,
            @RequestParam(name = "hourly") String hourly,
            @RequestParam(name = "timezone") String timezone,
            @RequestParam(name = "forecast_days") int forecastDays,
            @RequestParam(name = "latitude") String lat,
            @RequestParam(name = "longitude") String lng);
}
