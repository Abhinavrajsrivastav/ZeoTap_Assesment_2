package com.example.abhinav.whether.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "weather")
public class WeatherRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "City name cannot be blank")
    @Size(max = 100, message = "City name must not exceed 100 characters")
    private String city;

    @Size(max = 50, message = "Country name must not exceed 50 characters")
    private String country;

    @NotNull(message = "Temperature cannot be null")
    private BigDecimal temperature;

    @NotNull(message = "Humidity cannot be null")
    private Integer humidity;

    @NotBlank(message = "Weather description cannot be blank")
    @Size(max = 255, message = "Weather description must not exceed 255 characters")
    private String weatherDescription;

    private BigDecimal windSpeed;

    private String dateTime;

    public WeatherRecord() {
    }

    public WeatherRecord(String city, String country, BigDecimal temperature, Integer humidity,
                         String weatherDescription, BigDecimal windSpeed,  String dateTime) {
        this.city = city;
        this.country = country;
        this.temperature = temperature;
        this.humidity = humidity;
        this.weatherDescription = weatherDescription;
        this.windSpeed = windSpeed;
        this.dateTime = dateTime;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public BigDecimal getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(BigDecimal windSpeed) {
        this.windSpeed = windSpeed;
    }

    public  String getDateTime() {
        return dateTime;
    }

    public void setDateTime( String dateTime) {
        this.dateTime = dateTime;
    }
}
