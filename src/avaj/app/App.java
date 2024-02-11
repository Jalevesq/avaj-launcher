package avaj.app;
import avaj.controlcenter.SimulationController;

public class App {
    public static void main(String[] args) {
        SimulationController simulation = null;
        if (args.length != 1) {
            System.out.println("Pass the file path as a unique argument.");
            return ;
        }
        simulation = new SimulationController("scenario.txt");
        simulation.startSimulation();
        System.out.println("Simulation done !");
    }
}
