package AirVehicles;

public class Aircraft {
    protected long id_;
    protected String name_;
    protected Coordinates coordinates_;
    private static long idCounter_ = 0;
    
    protected Aircraft(String name, Coordinates coordinates) {
        this.name_ = name;
        this.coordinates_ = coordinates;
        this.id_ = nextId();
    }

    private static long nextId() {
        return idCounter_++;
    }

    public String getName() {
        return this.name_;
    }

    public long getId() {
        return this.id_;
    }

    public void printCoordinate() {
        System.out.println(this.coordinates_);
    }

}
