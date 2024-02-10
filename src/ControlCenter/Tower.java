package controlcenter;

import java.util.HashSet;
import java.util.Set;

public class Tower {
    private Set<Flyable> observers_;

    public Tower() {
        observers_ = new HashSet<>();
    }

    public void register(Flyable flyable) {
        observers_.add(flyable);
        System.out.println("Tower says: " + flyable.getFlyableInfo() + "registered to weather tower.");
    }

    public void unregister(Flyable flyable) {
        observers_.remove(flyable);
        System.out.println("Tower says: " + flyable.getFlyableInfo() + "unregistered to weather tower.");
    }

    public void conditionsChanged() {
        // Iterate through observer and update all of them so they do getWeather() ?
        for (Flyable flyable : observers_) {
            flyable.updateConditions();
        }
    }
}
