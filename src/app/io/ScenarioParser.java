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
        this.simulationCount = 0;
    }

    public void parseFile(String filePath) throws FileNotFoundException, IllegalArgumentException {
        Scanner scanner = new Scanner(new File(filePath));
        
        try {
            if (!scanner.hasNextLine()) {
                throw new IllegalArgumentException("File is empty.");
            }
            String firstLine = scanner.nextLine();
            try {
                simulationCount = Integer.parseInt(firstLine.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("The first line is not a valid integer: " + firstLine, e);
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
                    int longitude = Integer.parseInt(data[2]);
                    int latitude = Integer.parseInt(data[3]);
                    int height = Integer.parseInt(data[4]);
                    
                    if (longitude < 0 || latitude < 0 || height < 0) {
                        throw new IllegalArgumentException("Coordinates and height must be positive integers: " + line);
                    }
            
                    Flyable flyable = AircraftFactory.newAircraft(
                        data[0], // type
                        data[1], // name
                        longitude, // longitude
                        latitude, // latitude
                        height  // height
                    );
                    aircrafts.add(flyable);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Number format error in line: " + line, e);
                }
            }

            if (this.aircrafts.size() <= 0) {
                throw new IllegalArgumentException("The scenario need at least one flyable.");
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
