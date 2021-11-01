package Classes;

public class InvalidColorException extends Exception{
    public InvalidColorException(String text) {
        super("Invalid Color Exception: " + text);
    }
}
