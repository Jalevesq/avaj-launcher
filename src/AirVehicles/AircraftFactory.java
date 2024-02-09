package airvehicles;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import controlcenter.Flyable;
// import ControlCenter.Flyable;


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

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        BiFunction<String, Coordinates, Flyable> constructor = aircraftRegistry.get(type);
        if (constructor != null) {
            return constructor.apply(name, coordinates);
        } else {
            throw new IllegalArgumentException("No such aircraft type registered: " + type);
        }
    }
}
