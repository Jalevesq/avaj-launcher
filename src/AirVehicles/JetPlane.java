package airvehicles;

import controlcenter.Flyable;
import controlcenter.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weather;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        
    }

    @Override
    public void registerTower(WeatherTower WeatherTower) {
        
    }
}
