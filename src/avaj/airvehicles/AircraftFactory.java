package avaj.airvehicles;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import avaj.app.utils.AvajException;
import avaj.controlcenter.Flyable;


public class AircraftFactory {
    private static final Map<String, BiFunction<String, Coordinates, Flyable>> aircraftRegistry = new HashMap<>();
    
    static {
        registerAircraftType("Baloon", Baloon::new);
        registerAircraftType("Helicopter", Helicopter::new);
        registerAircraftType("JetPlane", JetPlane::new);
    }

    private static void registerAircraftType(String type, BiFunction<String, Coordinates, Flyable> constructor) {
        aircraftRegistry.put(type, constructor);
    }

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws AvajException{
        BiFunction<String, Coordinates, Flyable> constructor = aircraftRegistry.get(type);
        if (constructor != null) {
            if (height <= 0) {
                throw new AvajException("An aircraft cannot start with an height lower than 1.");
            }
            Coordinates coordinates = new Coordinates(longitude, latitude, height);
            return constructor.apply(name, coordinates);
        } else {
            throw new AvajException("No such aircraft type registered: " + type + ".");
        }
    }
}
