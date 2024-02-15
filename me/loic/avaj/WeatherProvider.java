package me.loic.avaj;

public class WeatherProvider {
    
    private static WeatherProvider instance;
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    public static WeatherProvider getInstance() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        var sum = coordinates.getLongitude() * coordinates.getLatitude() + coordinates.getHeight();
        return weather[(sum / 7) % weather.length];
    }
}
