package com.example.abhinav.whether.Entity.Service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.abhinav.whether.Model.WeatherRecord;
import com.example.abhinav.whether.Repository.WeatherRecordRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class SeeService {

    //API Credentials - API KEY and URL
    @Value("${weather.api.key}")
    private String apiKey;
    @Value("${weather.api.url}")
    private String apiUrl;

    @Autowired
    private WeatherRecordRepository weatherRecordRepository;

    // Getting Weather Updates on Screen...
    public String[] getWeather(String cityName) {
    try {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("%s/current.json?key=%s&q=%s", apiUrl, apiKey, cityName);
        ResponseEntity<ObjectNode> response = restTemplate.getForEntity(url, ObjectNode.class);

        //Getting Body of Json Response...
        ObjectNode json = response.getBody();

        if (json == null) {
            System.out.println("No data found for the city: " + cityName);
            return null;
        }

        //String array consisting all response values...
        String[] data = new String[7];
        data[0] = json.path("location").path("name").asText(); // City name
        data[1] = json.path("location").path("localtime").asText(); // Local time
        data[2] = json.path("current").path("temp_c").asText(); // Temperature
        data[3] = json.path("current").path("condition").path("icon").asText(); 
        data[4] = json.path("current").path("condition").path("text").asText(); 
        data[5] = json.path("current").path("wind_mph").asText(); // Wind speed
        data[6] = json.path("current").path("humidity").asText(); // Humidity

        String cityNameValue = data[0];
        String countryValue = json.path("location").path("country").asText(); 
        BigDecimal temperatureValue = new BigDecimal(data[2]);
        Integer humidityValue = Integer.parseInt(data[6]); 
        String descriptionValue = data[4];
        BigDecimal windSpeedValue = new BigDecimal(data[5]); 
     
        WeatherRecord weatherRecord = new WeatherRecord(cityNameValue, countryValue, temperatureValue, humidityValue, descriptionValue, windSpeedValue, data[1]);
        //saving the weather record in the database...
        weatherRecordRepository.save(weatherRecord);
        
        //returning the data array to the frontend...
        return data;

    } catch (HttpClientErrorException.NotFound e) {
        System.out.println("City not found: " + e.getMessage());
        return null;
    } catch (Exception e) {
        System.out.println("Error fetching weather information: " + e.getMessage());
        return null;
    }
}

// Getting Forecast Updates on Screen...
   public String[][] getForecast(String cityName) {
    try {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("%s/forecast.json?key=%s&q=%s&days=7", apiUrl, apiKey, cityName);
        ResponseEntity<ObjectNode> response = restTemplate.getForEntity(url, ObjectNode.class);
        //Getting Json response Body...
        ObjectNode json = response.getBody();

        if (json != null && json.path("forecast").path("forecastday").isArray()) {
            int days = json.path("forecast").path("forecastday").size();
            String[][] forecastData = new String[days][6]; 

            for (int i = 0; i < days; i++) {
                ObjectNode dayForecast = (ObjectNode) json.path("forecast").path("forecastday").get(i);

                String date = dayForecast.path("date").asText();
                String avgTemp = dayForecast.path("day").path("avgtemp_c").asText();
                String maxTemp = dayForecast.path("day").path("maxtemp_c").asText();
                String minTemp = dayForecast.path("day").path("mintemp_c").asText();
                String description = dayForecast.path("day").path("condition").path("text").asText();
                String time = json.path("location").path("localtime").asText();

                forecastData[i][0] = date;
                forecastData[i][1] = time;
                forecastData[i][2] = avgTemp + "°C";
                forecastData[i][3] = maxTemp + "°C";
                forecastData[i][4] = minTemp + "°C";
                forecastData[i][5] = description;
            }
            return forecastData;
        } else {
            System.out.println("No forecast data found.");
            return new String[0][0]; 
        }
    } catch (HttpClientErrorException.NotFound e) {
        System.out.println("City not found: " + e.getMessage());
        return new String[0][0]; 
    } catch (Exception e) {
        System.out.println("Error fetching forecast information: " + e.getMessage());
        return new String[0][0]; 
    }
}

}