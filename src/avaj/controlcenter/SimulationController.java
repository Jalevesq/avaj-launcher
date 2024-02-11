package avaj.controlcenter;

import java.util.List;

import avaj.app.utils.AvajException;
import avaj.app.utils.ScenarioParser;

import java.io.FileNotFoundException;

public class SimulationController {
    private int simulationCount_;
    private List<Flyable> aircraftDataList_;
    private WeatherTower weathertower_;

    public SimulationController(String filePath) {
        ScenarioParser parser = new ScenarioParser();
        try {
            parser.parseFile(filePath);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
            System.exit(1);
        } catch (AvajException e) {
            System.out.println("Error parsing file: " + e.getMessage());
            System.exit(1);
        } 
        this.simulationCount_ = parser.getSimulationCount();
        this.aircraftDataList_ = parser.getAircrafts();
        weathertower_ = new WeatherTower();
        attachFlyableToTower();
    }

    private void attachFlyableToTower() {
        for (Flyable flyable : aircraftDataList_) {
            flyable.registerTower(weathertower_);
        }
    }

    public void startSimulation() {
        int i = 0;
        while (i < simulationCount_) {
            // Logger.log("[Simulation " + (i + 1) + "]");
            weathertower_.changeWeather();
            i++;
        }
        // Logger.log("-- Simulation Finish --");
    }
}