package training.java.collections.list.exceptions;

public class NotNullValueAllowedException extends RuntimeException {
    public  NotNullValueAllowedException(){
        super("Null value not allowed");
    }
}
