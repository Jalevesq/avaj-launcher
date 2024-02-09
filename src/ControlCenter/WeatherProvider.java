package controlcenter;

import airvehicles.Coordinates;

public class WeatherProvider {
    public static WeatherProvider providerInstance = null;
    private String weather;

    private WeatherProvider() {
        weather = "DEFAULT_WEATHER";
    }

    public static WeatherProvider getInstance() {
        if (providerInstance == null) {
            if (providerInstance == null) {
                providerInstance = new WeatherProvider();
            }
        }
        return providerInstance;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return weather;
    }

}
