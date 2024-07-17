package com.lukasdev.weather_forecast.service;

import com.lukasdev.weather_forecast.client.WeatherForecastFeignClient;
import com.lukasdev.weather_forecast.model.WeatherData;
import com.lukasdev.weather_forecast.service.exceptions.ForecastDaysOutOfBoundsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WeatherForecastService {

    private final WeatherForecastFeignClient weatherForecastFeignClient;

    private final Logger logger = LoggerFactory.getLogger(WeatherForecastService.class);

    @Value("${forecast-config.current}")
    private String current;

    @Value("${forecast-config.hourly}")
    private String hourly;

    @Value("${forecast-config.timezone}")
    private String timezone;

    public WeatherForecastService(WeatherForecastFeignClient weatherForecastFeignClient) {
        this.weatherForecastFeignClient = weatherForecastFeignClient;
    }

    public WeatherData getWeatherDataForecast(String lat, String lgn, int forecastDays) {
        logger.info("received location info: {}, {}", lat, lgn);

        if (forecastDays <= 0) {
            forecastDays = 1;
        }

        if (forecastDays > 16) {
            throw new ForecastDaysOutOfBoundsException("Forecast days cannot be greater than 16 days");
        }

        return this.weatherForecastFeignClient.getWeatherData(
                current,
                hourly,
                timezone,
                forecastDays,
                lat, lgn);
    }
}
