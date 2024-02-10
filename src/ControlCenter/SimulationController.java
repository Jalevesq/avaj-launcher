package controlcenter;

import java.util.List;
import app.io.Logger;
import app.io.ScenarioParser;

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
            System.err.println("Error: File not found - " + e.getMessage());
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
            Logger.log("[Simulation " + i + "]");
            weathertower_.changeWeather();
            i++;
        }
    }
}