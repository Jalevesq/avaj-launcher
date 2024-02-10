package avaj.controlcenter;

import airvehicles.Coordinates;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        // Implement logic about changing it randomly and update all observer.
        this.conditionsChanged();
    }
}
