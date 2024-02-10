package app;
import controlcenter.SimulationController;

public class App {
    public static void main(String[] args) throws Exception {
        SimulationController simulation = null;
        try {
            simulation = new SimulationController("scenario.txt");
        } catch (IllegalArgumentException e) {
            System.err.println("Error parsing file: " + e.getMessage());
            System.exit(1);
        }

        simulation.startSimulation();
        System.out.println("Simulation done !");
    }
}
