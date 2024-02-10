package airvehicles;

public class Aircraft {
    protected long id_;
    protected String name_;
    protected String type_;
    protected Coordinates coordinates_;
    private static long idCounter_ = 1;
    
    protected Aircraft(String name, Coordinates coordinates) {
        this.name_ = name;
        this.coordinates_ = coordinates;
        this.id_ = nextId();
        this.type_ = "DEFAULT_TYPE";
    }

    private static long nextId() {
        return idCounter_++;
    }

    public void printCoordinate() {
        System.out.println(this.coordinates_);
    }

}
