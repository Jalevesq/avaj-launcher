package airvehicles;

import controlcenter.Flyable;
import controlcenter.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower_;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.type_ = "JetPlane";
    }

    @Override
    public String getFlyableInfo() {
        return this.type_ + "#" + this.name_ + "(" + this.id_ + ")";
    }

    @Override
    public void updateConditions() {
        String currentWeather = weatherTower_.getWeather(this.coordinates_);
        System.out.println(currentWeather);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower_ = weatherTower;
        weatherTower.register(this);
    }
}
