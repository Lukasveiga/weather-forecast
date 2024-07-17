package com.lukasdev.weather_forecast.config;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lukasdev.weather_forecast.model.CurrentWeatherData;
import com.lukasdev.weather_forecast.model.ForecastedWeatherData;
import com.lukasdev.weather_forecast.model.WeatherData;
import feign.FeignException;
import feign.Response;
import feign.codec.Decoder;

import java.io.IOException;
import java.lang.reflect.Type;

public class CustomDecoder implements Decoder {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public WeatherData decode(Response response, Type type) throws IOException, FeignException {
        this.objectMapper.registerModule(new JavaTimeModule());

        var node = this.objectMapper.readTree(response.body().asInputStream());
        var currentNode = node.get("current");
        var hourlyNode = node.get("hourly");

        var current = this.objectMapper.treeToValue(currentNode, CurrentWeatherData.class);
        var forecast = this.objectMapper.treeToValue(hourlyNode, ForecastedWeatherData.class);

        return new WeatherData(current, forecast);
    }
}
