package controlcenter;

import airvehicles.Coordinates;

public class WeatherTower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getInstance().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        
    }
}
