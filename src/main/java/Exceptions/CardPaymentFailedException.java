package Exceptions;

public class CardPaymentFailedException extends AppException {
    public CardPaymentFailedException(String message, Throwable cause) { super(message, cause); }
    public CardPaymentFailedException(String message) { super(message); }
}
