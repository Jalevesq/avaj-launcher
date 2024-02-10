package airvehicles;

import java.util.HashMap;
import java.util.Map;
import app.io.Logger;
import controlcenter.Flyable;
import controlcenter.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower_;
    private static Map<String, String> jetPlaneInfo_ = new HashMap<>();

    static {
        jetPlaneInfo_.put("FOG", "Hope you like mystery tours, because I can't see a thing!");
        jetPlaneInfo_.put("RAIN", "Turbo wipers on! Let's slice through this wet blanket.");
        jetPlaneInfo_.put("SUN", "Perfect weather for a loop-de-loop. Don't spill your coffee!");
        jetPlaneInfo_.put("SNOW", "Looks like we're flying through a giant snow globe. Mind the snowmen!");        
    }

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
        switch (currentWeather) {
            case "FOG":
                this.coordinates_ = new Coordinates(
                    this.coordinates_.getLongitude(),
                    this.coordinates_.getLatitude() + 1,
                    this.coordinates_.getHeight()
                );
                break;
            case "RAIN":
                this.coordinates_ = new Coordinates(
                    this.coordinates_.getLongitude(),
                    this.coordinates_.getLatitude() + 5,
                    this.coordinates_.getHeight()
                );
                break;
            case "SUN":
                this.coordinates_ = new Coordinates(
                    this.coordinates_.getLongitude(),
                    this.coordinates_.getLatitude() + 10,
                    this.coordinates_.getHeight() + 2
                );
                break;
            case "SNOW":
                this.coordinates_ = new Coordinates(
                    this.coordinates_.getLongitude(),
                    this.coordinates_.getLatitude(),
                    this.coordinates_.getHeight() - 7
                );
                break;

            }

            if (jetPlaneInfo_.containsKey(currentWeather)) {
                Logger.log(getFlyableInfo() + ": " + jetPlaneInfo_.get(currentWeather));
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
        this.weatherTower_.register(this);
    }
}
