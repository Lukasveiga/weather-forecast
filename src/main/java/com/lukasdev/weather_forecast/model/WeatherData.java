package com.lukasdev.weather_forecast.model;

public record WeatherData (
        CurrentWeatherData currentWeatherData,
        ForecastedWeatherData forecastedWeatherData
){
}
