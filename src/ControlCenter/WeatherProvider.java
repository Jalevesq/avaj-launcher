package controlcenter;

import airvehicles.Coordinates;

public class WeatherProvider {
    private static WeatherProvider providerInstance_ = null;
    private String[] weather_ = {"RAIN", "FOG", "SNOW", "SUN"};

    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        if (providerInstance_ == null) {
            if (providerInstance_ == null) {
                providerInstance_ = new WeatherProvider();
            }
        }
        return providerInstance_;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int seed = coordinates.getHeight() + coordinates.getHeight() + coordinates.getLatitude();
        seed += (int)(Math.random() * 100);
        return weather_[seed % 4];
    }
}
