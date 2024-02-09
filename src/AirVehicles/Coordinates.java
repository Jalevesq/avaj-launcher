package AirVehicles;

public class Coordinates {
    private int longitude_;
    private int latitude_;
    private int height_;

    public Coordinates(int longitude, int latitude, int height) {
        this.height_ = height;
        this.latitude_ = latitude;
        this.longitude_ = longitude;
    }

    public int getLongitude() {
        return this.longitude_;
    }

    public int getLatitude() {
        return this.latitude_;
    }

    public int getHeight() {
        return this.height_;
    }
}
