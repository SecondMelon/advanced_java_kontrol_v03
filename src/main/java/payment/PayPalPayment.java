package payment;

import Exceptions.PayPalPaymentFailedException;

public class PayPalPayment implements PaymentMethod {

    public PayPalPayment() {}

    public double paymentFee(double fee) {
        if (fee < 300) throw new PayPalPaymentFailedException("Value below minimum");
        return fee;
    }
}
