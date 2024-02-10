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
        long sum = (long)(coordinates.getHeight() + coordinates.getLongitude() + coordinates.getLatitude());
        long seed = sum + (long) (Math.random() * 100);
        
        int index = Math.abs((int) (seed % 4));
    
        return weather_[index];
    }
}
