package com.lukasdev.weather_forecast.service;

import com.lukasdev.weather_forecast.client.LocationFeignClient;
import com.lukasdev.weather_forecast.model.LocationData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    private final LocationFeignClient locationFeignClient;

    private final Logger logger = LoggerFactory.getLogger(LocationService.class);

    public LocationService(LocationFeignClient locationFeignClient) {
        this.locationFeignClient = locationFeignClient;
    }

    @Cacheable("locationsData")
    public LocationData getLocationCoordinates(String cep) {
        var locationData = this.locationFeignClient.getLocationData(cep);
        logger.info("returning location data: {},{}", locationData.lat(), locationData.lng());
        return locationData;
    }
}
