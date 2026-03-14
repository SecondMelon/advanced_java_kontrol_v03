package Exceptions;

public class PayPalPaymentFailedException extends AppException {
    public PayPalPaymentFailedException(String message, Throwable cause) { super(message, cause); }
    public PayPalPaymentFailedException(String message) { super(message); }
}
