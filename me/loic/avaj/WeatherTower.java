package me.loic.avaj;

public class WeatherTower extends Tower {
    
    public void changeWeather() {
        this.conditionChanged();
    }

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getInstance().getCurrentWeather(coordinates);
    }
}
