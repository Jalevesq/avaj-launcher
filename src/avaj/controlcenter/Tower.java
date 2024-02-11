package avaj.controlcenter;

import java.util.HashSet;
import java.util.Set;

import avaj.app.utils.Logger;

public class Tower {
    private Set<Flyable> observers_;

    public Tower() {
        observers_ = new HashSet<>();
    }

    public void register(Flyable flyable) {
        observers_.add(flyable);
        Logger.log("Tower says: " + flyable.getFlyableInfo() + " registered to weather tower.");
    }

    public void unregister(Flyable flyable) {
        observers_.remove(flyable);
        Logger.log("Tower says: " + flyable.getFlyableInfo() + " unregistered to weather tower.");
    }

    public void conditionsChanged() {
        Set<Flyable> observersCopy = new HashSet<>(observers_);
        for (Flyable flyable : observersCopy) {
            flyable.updateConditions();
        }
    }
}
