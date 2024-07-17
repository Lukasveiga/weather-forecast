package com.lukasdev.weather_forecast.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LocationData(
        String cep,
        String addressType,
        @JsonProperty("address_name")
        String addressName,
        String address,
        String neighborhood,
        String city,
        String state,
        String lat,
        String lng,
        String ddd,
        @JsonProperty("city_ibge")
        String cityIbge
) {
}
