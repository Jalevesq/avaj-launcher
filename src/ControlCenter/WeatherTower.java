package controlcenter;

import airvehicles.Coordinates;
import weather.WeatherProvider;

public class WeatherTower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getInstance().getCurrentWeather(coordinates);
    }

    void changeWeather() {

    }
}
