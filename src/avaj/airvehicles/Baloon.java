package avaj.airvehicles;

import java.util.HashMap;
import java.util.Map;

import avaj.app.utils.Logger;
import avaj.controlcenter.Flyable;
import avaj.controlcenter.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower_;
    private static Map<String, String> baloonInfo_ = new HashMap<>();

    static {
        baloonInfo_.put("FOG", "Who turned the world grayscale? Oh, it's just the fog.");
        baloonInfo_.put("RAIN", "Great, now I'm floating in a giant outdoor shower.");
        baloonInfo_.put("SUN", "Sun's out, buns out! Let's catch some rays and float away.");
        baloonInfo_.put("SNOW", "It's a winter wonderland up here. Too bad I can't make snow angels.");
    }

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.type_ = "Baloon";
    }

    @Override
    public void updateConditions() {
        String currentWeather = weatherTower_.getWeather(this.coordinates_);
        switch (currentWeather) {
            case "FOG":
                this.coordinates_ = new Coordinates(
                    this.coordinates_.getLongitude(),
                    this.coordinates_.getLatitude(),
                    this.coordinates_.getHeight() - 3
                );
                break;
            case "RAIN":
                this.coordinates_ = new Coordinates(
                    this.coordinates_.getLongitude(),
                    this.coordinates_.getLatitude(),
                    this.coordinates_.getHeight() - 5
                );
                break;
            case "SUN":
                int longitude = safeAdd(this.coordinates_.getLongitude(), 2);
                this.coordinates_ = new Coordinates(
                    longitude,
                    this.coordinates_.getLatitude(),
                    this.coordinates_.getHeight() + 4
                );
                break;
            case "SNOW":
                this.coordinates_ = new Coordinates(
                    this.coordinates_.getLongitude(),
                    this.coordinates_.getLatitude(),
                    this.coordinates_.getHeight() - 15
                );
                break;
        }

        if (baloonInfo_.containsKey(currentWeather)) {
            Logger.log(getFlyableInfo() + ": " + baloonInfo_.get(currentWeather));
        }

        if (this.coordinates_.getHeight() <= 0) {
            Logger.log(getFlyableInfo() + " landing at coordinate: " + coordinates_);
            this.weatherTower_.unregister(this);
            this.weatherTower_ = null;
        }
    }

    @Override
    public String getFlyableInfo() {
        return this.type_ + "#" + this.name_ + "(" + this.id_ + ")";
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        if (this.weatherTower_ != null) {
            this.weatherTower_.unregister(this);
        }
        this.weatherTower_ = weatherTower;
        weatherTower.register(this);
    }
}
