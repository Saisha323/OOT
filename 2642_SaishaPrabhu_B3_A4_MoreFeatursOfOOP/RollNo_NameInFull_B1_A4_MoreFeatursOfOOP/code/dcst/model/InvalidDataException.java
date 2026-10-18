package dcst.model;

/** Custom checked exception (feature 9). */
public class InvalidDataException extends Exception {
    public InvalidDataException(String message) { super(message); }
}
