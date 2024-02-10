package airvehicles;

import controlcenter.Flyable;
import controlcenter.WeatherTower;

public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weatherTower_;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.type_ = "Helicopter";
    }

    @Override
    public String getFlyableInfo() {
        return this.type_ + "#" + this.name_ + "(" + this.id_ + ")";
    }

    @Override
    public void updateConditions() {
        String currentWeather = weatherTower_.getWeather(this.coordinates_);
        System.out.println(currentWeather);
        if (currentWeather == "FOG") {

        } else if (currentWeather == "RAIN") {

        } else if (currentWeather == "SUN") {

        } else if (currentWeather == "SNOW") {
            
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower_ = weatherTower;
        weatherTower.register(this);
    }
}
