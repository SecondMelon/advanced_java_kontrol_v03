package domain;

import Exceptions.ItemsOverLimitException;
import Exceptions.PayPalPaymentFailedException;
import payment.PaymentMethod;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Order extends OrderProcessorTemplate {

    private List<OrderItem> orderList = new ArrayList<>();
    private Set<Integer> itemId = new HashSet<>();
    private PaymentMethod paymentMethod;
    private final String userEmail;

    public Order(PaymentMethod paymentMethod, String email) {
        this.userEmail = email;
        this.paymentMethod = paymentMethod;
    }

    public boolean addOrderItem(OrderItem orderItem) {
        if (orderList.size() > 10) throw new ItemsOverLimitException("Over 10 items");
        if (itemId.contains(orderItem.getId())) return false;

        orderList.add(orderItem);
        itemId.add(orderItem.getId());

        return true;
    }

    public void pay() {

    }
}
