import Exceptions.BankTransferPaymentFailedException;
import Exceptions.CardPaymentFailedException;
import Exceptions.PayPalPaymentFailedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import payment.BankTransferPayment;
import payment.CardPayment;
import payment.PayPalPayment;
import payment.PaymentMethod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CardPaymentTest {

    private PaymentMethod cardPayment;
    private PaymentMethod payPalPayment;
    private PaymentMethod bankTransferPayment;

    @BeforeEach
    void setUp() {
        this.cardPayment = new CardPayment();
        this.payPalPayment = new PayPalPayment();
        this.bankTransferPayment = new BankTransferPayment();
    }

    @ParameterizedTest
    @ValueSource (doubles = {31000, 300001, 653257})
    void cardPaymentShouldThrowException(double value) {
        assertThrows(CardPaymentFailedException.class, () -> cardPayment.paymentFee(value));
    }

    @ParameterizedTest
    @ValueSource (doubles = {150, 35, 299})
    void payPalPaymentShouldThrowException(double value) {
        assertThrows(PayPalPaymentFailedException.class, () -> payPalPayment.paymentFee(value));
    }

    @ParameterizedTest
    @ValueSource (doubles =  {0, -192, -5})
    void bankTransferPaymentShouldThrowOnNegativeValue(double value) {
        assertThrows(BankTransferPaymentFailedException.class, () -> bankTransferPayment.paymentFee(value));
    }

    @Test
    void cardPaymentShouldReturnStartingValue() {
        assertEquals(250.0, cardPayment.paymentFee(250), 0.001);
    }

    @Test
    void payPalPaymentShouldReturnStartingValue() {
        assertEquals(350.0, payPalPayment.paymentFee(350), 0.001);
    }

    @Test
    void cardPaymentShouldReturnStartingValueWithPercents() {
        assertEquals(204.0, bankTransferPayment.paymentFee(200), 0.001);
    }
}
