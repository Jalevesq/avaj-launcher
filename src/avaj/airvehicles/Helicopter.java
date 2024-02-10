package avaj.airvehicles;

import java.util.HashMap;
import java.util.Map;
import avaj.app.io.Logger;
import avaj.controlcenter.Flyable;
import avaj.controlcenter.WeatherTower;


public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weatherTower_;
    private static Map<String, String> helicopterInfo_ = new HashMap<>();

    static {
        helicopterInfo_.put("FOG", "Flying blind in pea soup! Where's my foghorn?");
        helicopterInfo_.put("RAIN", "It's a spa day! Free sky showers for everyone aboard.");
        helicopterInfo_.put("SUN", "Shades on, rotors spinning. It's beach patrol time!");
        helicopterInfo_.put("SNOW", "Who ordered the sky confetti? Watch out for the whiteout party.");        
    }


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
        switch (currentWeather) {
            case "FOG":
                int longitudeFog = safeAdd(this.coordinates_.getLongitude(), 1);
                this.coordinates_ = new Coordinates(
                    longitudeFog,
                    this.coordinates_.getLatitude(),
                    this.coordinates_.getHeight()
                );
                break;
            case "RAIN":
                int longitudeRain = safeAdd(this.coordinates_.getLongitude(), 5);
                this.coordinates_ = new Coordinates(
                    longitudeRain,
                    this.coordinates_.getLatitude(),
                    this.coordinates_.getHeight()
                );
                break;
            case "SUN":
                int longitudeSun = safeAdd(this.coordinates_.getLongitude(), 10);
                this.coordinates_ = new Coordinates(
                    longitudeSun,
                    this.coordinates_.getLatitude(),
                    this.coordinates_.getHeight() + 2
                );
                break;
            case "SNOW":
                this.coordinates_ = new Coordinates(
                    this.coordinates_.getLongitude(),
                    this.coordinates_.getLatitude(),
                    this.coordinates_.getHeight() - 12
                );
                break;
        }

        if (helicopterInfo_.containsKey(currentWeather)) {
            Logger.log(getFlyableInfo() + ": " + helicopterInfo_.get(currentWeather));
        }

        if (this.coordinates_.getHeight() <= 0) {
            Logger.log(getFlyableInfo() + " landing at coordinate: " + coordinates_);
            this.weatherTower_.unregister(this);
            this.weatherTower_ = null;
        }
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
