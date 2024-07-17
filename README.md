<div align="center">
    <img src="https://cdn.iconscout.com/icon/free/png-256/free-weather-296-1100758.png" width=80/>
    <h2>Weather Forecast Spring API</h2>
</div>

<p align="center">
     <a alt="Java">
        <img src="https://img.shields.io/badge/Java-v17-blue.svg" />
    </a>
<a alt="Spring">
        <img src="https://img.shields.io/badge/Spring Boot-v3.3.1-green.svg" />
    </a>
    <a alt="OpenFeign">
        <img src="https://img.shields.io/badge/OpenFeign-v4.1.3-purple.svg" />
    </a>
</p>

### Overview

The Weather Forecast API allows users to retrieve weather forecasts based on their CEP (Postal Code) location. The API uses OpenFeign to integrate with external services to convert CEP to latitude and longitude, and then to fetch weather data using these coordinates.

## Technologies

- Spring Boot
- OpenFeign

## Endpoint

Request:
* Method: GET
* Url: http://localhost:8080/api/v1/weather-forecast/{cep}?forecast_days=1
* Path param: `cep` (String): The CEP (Postal Code) for which to retrieve the weather forecast.
* Query param: `forecast_days` (Integer): Forecasts days.

## External APIs

### CEP to Latitude/Longitude API

- Base URL: https://cep.awesomeapi.com.br/json
- Method: GET
- Query Parameter:
  - cep (String): The CEP for which to retrieve data includin coordinates.

### Weather Data API

- Base URL: https://api.open-meteo.com/v1/forecast
- Method: GET
- Query Parameters:
  - latitude (Double): The latitude coordinate.
  - longitude (Double): The longitude coordinate.
  - current: A list of weather variables to get current conditions.
  - forecast_days: Per default, only 7 days are returned. Up to 16 days of forecast are possible.
- And others. See documentation: https://open-meteo.com/en/docs
