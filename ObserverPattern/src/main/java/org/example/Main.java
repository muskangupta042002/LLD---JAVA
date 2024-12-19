package org.example;

public class Main {
    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay=new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(78,90, 39.2f);
    }
}