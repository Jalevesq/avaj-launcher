package controlcenter;

import java.util.HashSet;
import java.util.Set;

public class Tower extends WeatherTower {
    private Set<Flyable> observers;

    public Tower() {
        observers = new HashSet<>();
    }

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    public void conditionsChanged() {
        // Iterate through observer and update all of them so they do getWeather() ?
    }
}
