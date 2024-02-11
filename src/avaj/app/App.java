package avaj.app;
import avaj.app.utils.AvajException;
import avaj.controlcenter.SimulationController;

public class App {
    public static void main(String[] args) {
        SimulationController simulation = null;
        if (args.length != 1) {
            System.out.println("Pass the file path as a unique argument.");
        } else if("help".equals(args[0])) {
            AvajException.printHelp();
        } else {
            simulation = new SimulationController(args[0]);
            simulation.startSimulation();
            System.out.println("Simulation done !");
        }

    }
}
