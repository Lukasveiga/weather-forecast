package com.lukasdev.weather_forecast.config;

import feign.codec.Decoder;
import org.springframework.context.annotation.Bean;

public class FeignConfig {

    @Bean
    public Decoder customDecoder() {
        return new CustomDecoder();
    }
}
