package avaj.airvehicles;

public class Coordinates {
    private int longitude_;
    private int latitude_;
    private int height_;

    Coordinates(int longitude, int latitude, int height) {
        if (height > 100)
            height = 100;
        if (height < 0)
            height = 0;
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

    @Override
    public String toString() {
        return "longitude: " + this.longitude_ + ", latitude: " + this.latitude_ + ", height: " + this.height_;
    }
}
