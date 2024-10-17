package com.example.abhinav.whether.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.abhinav.whether.Model.WeatherRecord;

public interface WeatherRecordRepository extends JpaRepository<WeatherRecord, Integer> {
    boolean existsByCityAndDateTime(String city, String dateTime);
}
