package app.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import airvehicles.AircraftFactory;
import controlcenter.Flyable;

public class ScenarioParser {

    private int simulationCount;
    private List<Flyable> aircrafts;

    public ScenarioParser() {
        this.aircrafts = new ArrayList<>();
    }

    public void parseFile(String filePath) throws FileNotFoundException, IllegalArgumentException {
        Scanner scanner = new Scanner(new File(filePath));

        try {
            if (scanner.hasNextLine()) {
                String firstLine = scanner.nextLine();
                try {
                    simulationCount = Integer.parseInt(firstLine.trim());
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("The first line is not a valid integer: " + firstLine, e);
                }
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(" ");
                if (data.length < 5) {
                    throw new IllegalArgumentException("Incomplete data line: " + line);
                } else if (data.length > 5) {
                    throw new IllegalArgumentException("Too many data line: " + line);
                }
                try {
                    Flyable flyable = AircraftFactory.newAircraft(
                        data[0], // type
                        data[1], // name
                        Integer.parseInt(data[2]), // longitude
                        Integer.parseInt(data[3]), // latitude
                        Integer.parseInt(data[4])  // height
                    );
                    aircrafts.add(flyable);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Number format error in line: " + line, e);
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException(e.getMessage() + " line: " + line, e);
                }
            }
        } finally {
            scanner.close();
        }
    }

    public int getSimulationCount() {
        return simulationCount;
    }

    public List<Flyable> getAircrafts() {
        return aircrafts;
    }
}
