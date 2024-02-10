package airvehicles;

import java.util.HashSet;
import java.util.Set;

import controlcenter.Flyable;
import controlcenter.WeatherTower;

public class Helicopter extends Aircraft implements Flyable{
    private Set<WeatherTower> weatherTower_;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.weatherTower_ = new HashSet<>();
    }

    @Override
    public String getFlyableInfo() {
        return "Helicopter#" + this.getName() + "(" + this.getId() + ")";
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower_.add(weatherTower);
        weatherTower.register(this);
    }
}
