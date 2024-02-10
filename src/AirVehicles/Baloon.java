package airvehicles;

import java.util.HashSet;
import java.util.Set;

import controlcenter.Flyable;
import controlcenter.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private Set<WeatherTower> weatherTower_;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.weatherTower_ = new HashSet<>();
    }

    @Override
    public void updateConditions() {
        
    }

    @Override
    public String getFlyableInfo() {
        return "Baloon#" + this.getName() + "(" + this.getId() + ")";
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower_.add(weatherTower);
        weatherTower.register(this);
    }
}
