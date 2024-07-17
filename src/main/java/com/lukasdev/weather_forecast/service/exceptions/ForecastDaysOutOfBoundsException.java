package com.lukasdev.weather_forecast.service.exceptions;

public class ForecastDaysOutOfBoundsException extends RuntimeException{
    public ForecastDaysOutOfBoundsException(String message) {
        super(message);
    }
}
