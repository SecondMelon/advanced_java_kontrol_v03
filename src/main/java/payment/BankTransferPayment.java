package payment;

import Exceptions.BankTransferPaymentFailedException;

public class BankTransferPayment implements PaymentMethod {

    public BankTransferPayment() {}

    public double paymentFee(double fee) {
        if (fee <= 0) throw new BankTransferPaymentFailedException("Value is below minimum");
        return fee * 1.02;
    }
}
