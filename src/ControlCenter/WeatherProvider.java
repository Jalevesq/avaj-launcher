package controlcenter;

import airvehicles.Coordinates;

public class WeatherProvider {
    private static WeatherProvider providerInstance_ = null;
    private String weather_;

    private WeatherProvider() {
        weather_ = "DEFAULT_WEATHER";
    }

    public static WeatherProvider getProvider() {
        if (providerInstance_ == null) {
            if (providerInstance_ == null) {
                providerInstance_ = new WeatherProvider();
            }
        }
        return providerInstance_;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return weather_;
    }
}
