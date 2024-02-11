package avaj.controlcenter;

import avaj.airvehicles.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider_ = null;
    private String[] weather_ = {"RAIN", "FOG", "SNOW", "SUN"};

    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        if (weatherProvider_ == null) {
            weatherProvider_ = new WeatherProvider();
        }
        return weatherProvider_;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        long sum = (long)(coordinates.getHeight() + coordinates.getLongitude() + coordinates.getLatitude());
        long seed = sum + (long) (Math.random() * 100);
        
        int index = Math.abs((int) (seed % 4));
    
        return weather_[index];
    }
}
