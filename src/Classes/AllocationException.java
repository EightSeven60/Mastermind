package Classes;

public class AllocationException extends Exception{
    public AllocationException(String text) {
        super("Allocation Exception: " + text);
    }
}
