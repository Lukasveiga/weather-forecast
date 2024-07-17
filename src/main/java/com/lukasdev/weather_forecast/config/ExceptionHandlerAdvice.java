package com.lukasdev.weather_forecast.config;

import com.lukasdev.weather_forecast.service.exceptions.ForecastDaysOutOfBoundsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    private final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    @ExceptionHandler(ForecastDaysOutOfBoundsException.class)
    ResponseEntity<String> handleForecastException(ForecastDaysOutOfBoundsException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
