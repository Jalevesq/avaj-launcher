package airvehicles;

import java.util.HashSet;
import java.util.Set;

import controlcenter.Flyable;
import controlcenter.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private Set<WeatherTower> weatherTower_;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.weatherTower_ = new HashSet<>();
    }

    @Override
    public String getFlyableInfo() {
        return "JetPlane#" + this.getName() + "(" + this.getId() + ")";
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
