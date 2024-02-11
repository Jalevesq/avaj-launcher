package avaj.app.utils;

public class AvajException extends Exception {
    public AvajException(String message) {
        super(message);
    }

    public AvajException() {
        super("Default Exception");
    }
}
