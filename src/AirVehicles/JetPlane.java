package airvehicles;

import controlcenter.Flyable;
import controlcenter.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower_;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.type_ = "JetPlane";
        weatherTower_ = null;
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
                this.coordinates_.getLatitude() + 1,
                this.coordinates_.getHeight()
            );
        } else if (currentWeather == "RAIN") {
            this.coordinates_ = new Coordinates(
                this.coordinates_.getLongitude(),
                this.coordinates_.getLatitude() + 5,
                this.coordinates_.getHeight()
            );
        } else if (currentWeather == "SUN") {
            this.coordinates_ = new Coordinates(
                this.coordinates_.getLongitude(),
                this.coordinates_.getLatitude() + 10,
                this.coordinates_.getHeight() + 2
            );
        } else if (currentWeather == "SNOW") {
            this.coordinates_ = new Coordinates(
                this.coordinates_.getLongitude(),
                this.coordinates_.getLatitude(),
                this.coordinates_.getHeight() - 7
            );
        }
        if (this.coordinates_.getHeight() <= 0) {
            System.out.println(getFlyableInfo() + " landing.");
            weatherTower_.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        if (this.weatherTower_ != null) {
            this.weatherTower_.unregister(this);
        }
        this.weatherTower_ = weatherTower;
        this.weatherTower_.register(this);
    }
}
