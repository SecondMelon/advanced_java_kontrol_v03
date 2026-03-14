package Exceptions;

public class BankTransferPaymentFailedException extends AppException {
    public BankTransferPaymentFailedException(String message, Throwable cause) { super(message, cause); }
    public BankTransferPaymentFailedException(String message) { super(message); }
}
