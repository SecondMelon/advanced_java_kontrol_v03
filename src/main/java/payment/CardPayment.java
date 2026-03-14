package payment;

import Exceptions.CardPaymentFailedException;

public class CardPayment implements PaymentMethod {

    public double paymentFee(double fee) {
        if (fee <= 0)
            throw new CardPaymentFailedException("Too low value");
        if (fee > 30000)
            throw new CardPaymentFailedException("Value over limit");
        return fee;
    }
}
