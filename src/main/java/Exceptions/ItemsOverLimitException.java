package Exceptions;

public class ItemsOverLimitException extends AppException {
    public ItemsOverLimitException(String message, Throwable cause) { super(message, cause); }
    public ItemsOverLimitException(String message) { super(message); }
}
