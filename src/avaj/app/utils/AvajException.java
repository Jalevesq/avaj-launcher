package avaj.app.utils;

public class AvajException extends Exception {
    public AvajException(String message) {
        super(message);
    }

    public AvajException() {
        super("Default Exception");
    }

    public static void printHelp() {
        System.out.println("Usage: Provide a path to a scenario file as the program argument.");
        System.out.println("The scenario file should be formatted as follows:");
        System.out.println("The first line indicates the number of times the simulation will run.");
        System.out.println("<number of times the simulation will run>");
        System.out.println("Each following line describes an aircraft using the format:");
        System.out.println("<type> <name> <longitude> <latitude> <height>");
        System.out.println("Where:");
        System.out.println("- <type> is one of Baloon, JetPlane, or Helicopter");
        System.out.println("- <name> is a name for the aircraft");
        System.out.println("- <longitude>, <latitude>, <height> are positive integers representing the aircraft's coordinates");
        System.out.println("\nExample:");
        System.out.println("25");
        System.out.println("Baloon B1 2 3 20");
        System.out.println("Baloon B2 1 8 66");
        System.out.println("JetPlane J1 23 44 32");
        System.out.println("Helicopter H1 654 33 20");
        System.out.println("Helicopter H2 22 33 44");
        System.out.println("Helicopter H3 98 68 99");
        System.out.println("Baloon B3 102 2 34");
        System.out.println("JetPlane J2 11 99 768");
        System.out.println("Helicopter H4 223 23 54");
    }
}
