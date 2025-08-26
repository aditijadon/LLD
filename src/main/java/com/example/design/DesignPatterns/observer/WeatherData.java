package com.example.design.DesignPatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements ISubject{
    private int temperature;
    private int humidity;
    private int pressure;
    private List<IObserver> observers;

    public WeatherData() {
        observers = new ArrayList<IObserver>();
    }

    public void addObserver(IObserver o){
        observers.add(o);
    }

    public void removeObserver(IObserver o){
        observers.remove(o);
    }

    public void notifyObservers(){
        for(IObserver o : observers){
            o.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(int temperature, int humidity, int pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

}
