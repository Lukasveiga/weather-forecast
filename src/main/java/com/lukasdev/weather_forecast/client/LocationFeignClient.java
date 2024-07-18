package com.lukasdev.weather_forecast.client;

import com.lukasdev.weather_forecast.model.LocationData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "location", url = "${url.location}")
public interface LocationFeignClient {

    @GetMapping(value = "/{cep}", produces = MediaType.APPLICATION_JSON_VALUE)
    LocationData getLocationData(@PathVariable("cep") String cep);
}

