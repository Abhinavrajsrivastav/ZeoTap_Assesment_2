# Java Spring Boot and React.js Project - Weather Monitoring System with OpenWeatherMap API Assesment 2

Develop a ***real-time data processing system*** to monitor weather conditions and provide
summarized insights using rollups and aggregates. The system will utilize data from the
OpenWeatherMap API ***(https://openweathermap.org/)***.



## Project Structure
```
  ZeoTap Assessment 2 # Root directory
```

## Prerequisites

Make sure you have the following installed:
- **Maven**: [Download](https://maven.apache.org/download.cgi)
- **Java 17 or above**: [Download](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- **Spring Boot**: [Download](https://spring.io/projects/spring-boot)

## Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/Abhinavrajsrivastav/ZeoTap_Assesment_2.git
cd ZeoTap Assessment 2
```


### 2. Application Setup (Spring Boot)
navigate to application.properties
add the apikey for openweathermap api key in the application.properties file
add database credentials in the application.properties file(SQL table schema should similar to WeatherRecord.java)
```bash

Run the Spring Boot application:
```bash
mvn spring-boot:run
```
The backend API will be running at:  
**http://localhost:8089**

## Used API
- **OpenWeatherMap API**: [https://openweathermap.org/](https://openweathermap.org/)
  

Sample API endpoints:
```
GET /wheteherApp
POST /wheteherApp
```

## Accessing the Application

- **Application Start**: [http://localhost:8089](http://localhost:8089)  


## Technologies Used

- **Frontend**: HTML, CSS, JavaScript  
- **Backend**: Java, Spring Boot, Maven, RESTful APIs  
- **Database**: MySQL, H2  
- **DevOps**: GitHub Actions  
- **APIs**: OpenWeatherMap API

## Features Implemented

1. **Real-time Data Processing**: The system processes real-time weather data from the OpenWeatherMap API.
details: 
    - **Date and Time**
    - **Temperature**
    - **Humidity**
    - **Wind Speed**
    - **Weather Condition**
    - **Min Temperature**
    - **Max Temperature**
    - **City Name**
    -**Surrounding conditions**

2. **Weather Forecast**: The system provides a weather forecast for the next 3 days. including the following details:
    - **Date**
    - **Temperature**
    - **Humidity**
    - **Wind Speed**
    - **Weather Condition**
    - **Min Temperature**
    - **Max Temperature**

3. **Data Saved in Database**: The weather data is saved in a MySQL database.

## Contributing

1. Fork the repository.  
2. Create a new branch: `git checkout -b feature-branch`.  
3. Make your changes and commit: `git commit -m 'Add feature'`.  
4. Push to the branch: `git push origin feature-branch`.  
5. Open a pull request.

## License

This project is licensed under the ZeoTap Internship (2025) Assessment Purpose.
