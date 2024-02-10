package avaj.controlcenter;

public interface Flyable {

    public void updateConditions();
    public void registerTower(WeatherTower WeatherTower);
    public String getFlyableInfo();
}