package airvehicles;

import controlcenter.Flyable;
import controlcenter.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower_;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.type_ = "Baloon";
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
                this.coordinates_.getLongitude(),
                this.coordinates_.getLatitude(),
                this.coordinates_.getHeight() - 3
            );
        } else if (currentWeather == "RAIN") {
            this.coordinates_ = new Coordinates(
                this.coordinates_.getLongitude(),
                this.coordinates_.getLatitude(),
                this.coordinates_.getHeight() - 5
            );
        } else if (currentWeather == "SUN") {
            this.coordinates_ = new Coordinates(
                this.coordinates_.getLongitude() + 2,
                this.coordinates_.getLatitude(),
                this.coordinates_.getHeight() + 4
            );
        } else if (currentWeather == "SNOW") {
            this.coordinates_ = new Coordinates(
                this.coordinates_.getLongitude(),
                this.coordinates_.getLatitude(),
                this.coordinates_.getHeight() - 15
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
