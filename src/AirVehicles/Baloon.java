package airvehicles;

import java.util.HashMap;
import java.util.Map;
import app.simulation.Logger;
import controlcenter.Flyable;
import controlcenter.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower_;
    private static Map<String, String> baloonInfo = new HashMap<>();

    static {
        baloonInfo.put("FOG", "Who turned the world grayscale? Oh, it's just the fog.");
        baloonInfo.put("RAIN", "Great, now I'm floating in a giant outdoor shower.");
        baloonInfo.put("SUN", "Sun's out, buns out! Let's catch some rays and float away.");
        baloonInfo.put("SNOW", "It's a winter wonderland up here. Too bad I can't make snow angels.");
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
                this.coordinates_ = new Coordinates(
                    this.coordinates_.getLongitude() + 2,
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

        if (baloonInfo.containsKey(currentWeather)) {
            Logger.log(getFlyableInfo() + ": " + baloonInfo.get(currentWeather));
        }

        if (this.coordinates_.getHeight() <= 0) {
            System.out.println(getFlyableInfo() + " landing.");
            this.weatherTower_.unregister(this);
            Logger.log(getFlyableInfo() + " unregistered from weather tower.");
        }
    }

    @Override
    public String getFlyableInfo() {
        return this.type_ + "#" + this.name_ + "(" + this.id_ + ")";
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower_ = weatherTower;
        weatherTower.register(this);
    }
}
