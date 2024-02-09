package airvehicles;

import controlcenter.Flyable;
import controlcenter.WeatherTower;

public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weather;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        
    }

    @Override
    public void registerTower(WeatherTower WeatherTower) {
        
    }
}
