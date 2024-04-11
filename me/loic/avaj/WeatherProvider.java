package me.loic.avaj;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class WeatherProvider {
    
    private static WeatherProvider instance;
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    private Map<Integer, String> weatherMap = new HashMap<Integer, String>();

    public static WeatherProvider getInstance() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        var sum = coordinates.getLongitude() * coordinates.getLatitude() + coordinates.getHeight();
        var random = new Random().nextInt(weather.length);
        if (weatherMap.containsKey(sum)) {
            return weatherMap.get(sum);
        }
        weatherMap.put(sum, weather[random]);
        return weather[random];
    }
}
