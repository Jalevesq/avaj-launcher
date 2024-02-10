package app;
import airvehicles.AircraftFactory;
import controlcenter.Flyable;

public class App {
    public static void main(String[] args) throws Exception {

        // Parsing file:
        // Check that all number are positive.
        // Height can't be higher than 100.
        // First number = number of time to run simulation.
        // Respect form: TYPE NAME LONGITUDE LATITUDE HEIGHT
        Flyable somethingIsFlying = AircraftFactory.newAircraft("Helicopter", "test", 5, 0, 0);

        System.out.println(somethingIsFlying.getFlyableInfo());
    }
}
