package avaj.app.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import avaj.airvehicles.AircraftFactory;
import avaj.controlcenter.Flyable;

public class ScenarioParser {

    private int simulationCount;
    private List<Flyable> aircrafts;

    public ScenarioParser() {
        this.aircrafts = new ArrayList<>();
        this.simulationCount = 0;
    }

    public void parseFile(String filePath) throws FileNotFoundException, IllegalArgumentException {
        Scanner scanner = new Scanner(new File(filePath));
        
        try {
            if (!scanner.hasNextLine()) {
                throw new IllegalArgumentException("File is empty.");
            }
            this.simulationCount = getFirstLine(scanner);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(" ");
                if (data.length == 1 && line.length() == 0) // Ignore empty line
                    continue;
                if (data.length < 5) {
                    throw new IllegalArgumentException("Incomplete data line: " + line);
                } else if (data.length > 5) {
                    throw new IllegalArgumentException("Too many data line: " + line);
                }
                Flyable flyable = this.createAircraft(data);
                aircrafts.add(flyable);
            }
            if (this.aircrafts.size() <= 0) {
                throw new IllegalArgumentException("The scenario need at least one flyable.");
            }
        } finally {
            scanner.close();
        }
    }

    private Flyable createAircraft(String[] data) {
        int height;
        int latitude;
        int longitude;
        try {
            longitude = Integer.parseInt(data[2]);
            latitude = Integer.parseInt(data[3]);
            height = Integer.parseInt(data[4]);
            if (longitude < 0 || latitude < 0 || height < 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            String arrayString = Arrays.toString(data);
            throw new IllegalArgumentException("Coordinates and height must be positive integers. line: " + arrayString.substring(1, arrayString.length() - 1), e);
        }
        

        Flyable flyable = AircraftFactory.newAircraft(
            data[0], // type
            data[1], // name
            longitude, // longitude
            latitude, // latitude
            height  // height
        );
        return flyable;
    }

    private int getFirstLine(Scanner scanner) {
            String firstLine = scanner.nextLine();
            firstLine = firstLine.trim();
            if (firstLine.isEmpty()) {
                throw new IllegalArgumentException("First line is empty.");
            }

            try {
                int simulationCount = Integer.parseInt(firstLine);
                if (simulationCount < 0) {
                    throw new NumberFormatException();
                }
                return simulationCount;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("The first line is not a valid positive integer: " + firstLine, e);
            }
    }

    public int getSimulationCount() {
        return simulationCount;
    }

    public List<Flyable> getAircrafts() {
        return aircrafts;
    }
}
