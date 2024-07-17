package com.lukasdev.weather_forecast.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

public record ForecastedWeatherData (
        List<LocalDateTime> time,
        @JsonProperty("temperature_2m")
        List<Double> temperature2m
){
}
