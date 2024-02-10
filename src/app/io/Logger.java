package app.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class Logger {
    private static File outfile;
    private static BufferedWriter outfileWriter;

    static {
        try {
            outfile = new File("simulator.txt");
            outfileWriter = new BufferedWriter(new FileWriter(outfile));
            Runtime.getRuntime().addShutdownHook(new Thread(Logger::closeLog));
        } catch (IOException e) {
            System.err.println("Error: Couldn't create simulation file.");
            System.exit(1);
        }
    }

    public static void log(String msg) {
        try {
            outfileWriter.write(msg);
            outfileWriter.newLine();
            outfileWriter.flush();
        } catch (IOException e) {
            System.err.println("Error: Couldn't write line in file: " + msg);
            System.exit(1);
        }
    }

    private static void closeLog() {
        if (outfileWriter != null) {
            try {
                outfileWriter.close();
            } catch (IOException e) {
                System.err.println("Error: Couldn't close file correctly.");
                System.exit(1);
            }
        }
    }
}