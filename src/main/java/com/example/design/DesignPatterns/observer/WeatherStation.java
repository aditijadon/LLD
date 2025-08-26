package com.example.design.DesignPatterns.observer;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        weatherData.setMeasurements(80, 54, 30);
        weatherData.setMeasurements(78, 66, 43);
//        weatherData.removeObserver(currentConditionDisplay);
        weatherData.setMeasurements(85, 56, 48);
    }
}
