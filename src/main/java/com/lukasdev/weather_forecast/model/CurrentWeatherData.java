package com.lukasdev.weather_forecast.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record CurrentWeatherData(
        LocalDateTime time,
        int interval,
        @JsonProperty("temperature_2m")
        double temperature2m,
        @JsonProperty("relative_humidity_2m")
        int relativeHumidity2m,
        @JsonProperty("wind_speed_10m")
        double windSpeed10m
) {
}
