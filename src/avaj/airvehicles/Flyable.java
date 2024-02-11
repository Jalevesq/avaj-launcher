package avaj.airvehicles;

import avaj.controlcenter.WeatherTower;

public interface Flyable {

    public void updateConditions();
    public void registerTower(WeatherTower WeatherTower);
    public String getFlyableInfo();
}