package org.example;

public class CurrentConditionsDisplay implements Observer, DisplayElement{

    private WeatherData weatherData;
    private float humidity;
    private float temperature;

    public  CurrentConditionsDisplay(WeatherData weatherData){
        this.weatherData=weatherData;
        weatherData.registerObservers(this);
    }
    @Override
    public void display() {
        System.out.println("Current Conditions: " + temperature
            + "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature=temp;
        this.humidity=humidity;
        display();
    }

}
