package avaj.app;
import controlcenter.SimulationController;

public class App {
    public static void main(String[] args) throws Exception {
        SimulationController simulation = null;
        try {
            if (args.length != 1) {
                throw new IllegalArgumentException("Pass the file path as a unique argument.");
            }
            simulation = new SimulationController("scenario.txt");
        } catch (IllegalArgumentException e) {
            System.out.println("Error parsing file: " + e.getMessage());
            System.exit(1);
        }

        simulation.startSimulation();
        System.out.println("Simulation done !");
    }
}
