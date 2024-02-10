package app;
import airvehicles.AircraftFactory;
import controlcenter.Flyable;

public class App {
    public static void main(String[] args) throws Exception {

        Flyable somethingIsFlying = AircraftFactory.newAircraft("Helicopter", "Fat momma", 5, 0, 0);

        System.out.println(somethingIsFlying.getFlyableInfo());
    }
}
