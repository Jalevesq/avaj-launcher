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
            this.coordinates_ = new Coordinates(
                this.coordinates_.getLongitude() + 1,
                this.coordinates_.getLatitude(),
                this.coordinates_.getHeight()
            );
        } else if (currentWeather == "RAIN") {
            this.coordinates_ = new Coordinates(
                this.coordinates_.getLongitude() + 5,
                this.coordinates_.getLatitude(),
                this.coordinates_.getHeight()
            );
        } else if (currentWeather == "SUN") {
            this.coordinates_ = new Coordinates(
                this.coordinates_.getLongitude() + 10,
                this.coordinates_.getLatitude(),
                this.coordinates_.getHeight() + 2
            );
        } else if (currentWeather == "SNOW") {
            this.coordinates_ = new Coordinates(
                this.coordinates_.getLongitude(),
                this.coordinates_.getLatitude(),
                this.coordinates_.getHeight() - 12
            );
        }
        // Create logger

        if (this.coordinates_.getHeight() <= 0) {
            System.out.println(getFlyableInfo() + " landing.");
            weatherTower_.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower_ = weatherTower;
        weatherTower.register(this);
    }
}
