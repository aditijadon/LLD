package com.example.design.DesignPatterns.observer;

public class CurrentConditionDisplay implements IObserver, IDisplayElement{
    private int temperature;
    private int humidity;
    private WeatherData weatherData;

    CurrentConditionDisplay(WeatherData weatherData){  // if WeatherDatat is being passed here it means we can call update without arguments
        this.weatherData = weatherData;
        weatherData.addObserver(this);
    }

//    public void update(){
//        this.temperature = weatherData.getTemperature();
//        this.humidity = weatherData.getHumidity();
//        display();
//    }

    public void update(int temperature, int humidity, int pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    public void display(){
        System.out.println("Current Weather: " + temperature + "F degrees and " + humidity + " % humidity");
    }
}

/* If we con't pass that object in constructor it's like one subject can talk to observer
    but observers don't know who the subject is but when it's passed in the constructor it knows
    which suject has it subscribed to and also the subscription can happen in constructor only
    otherwise we had to do addObserver(currentConditionDisplay) explicitly in the station class.
*/
