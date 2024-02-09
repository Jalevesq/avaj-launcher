package app;
import airvehicles.AircraftFactory;
import airvehicles.Helicopter;
import controlcenter.Flyable;

public class App {
    public static void main(String[] args) throws Exception {
        Helicopter helicopter = null;
        Helicopter helicopter2 = null;

        Flyable somethingIsFlying = AircraftFactory.newAircraft("Helicopter", "Fat momma", 5, 0, 0);
        if (somethingIsFlying instanceof Helicopter) {
            helicopter = (Helicopter)somethingIsFlying; 
        }
        helicopter2 = helicopter;

        String name = helicopter.getName();
        long id = helicopter.getId();
        
        String name2 = helicopter2.getName();
        long id2 = helicopter2.getId();
    
        System.out.println(name + " " + id);
        System.out.println(name2 + " " + id2);

        helicopter.printCoordinate();
    }
}
