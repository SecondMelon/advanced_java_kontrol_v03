package domain;

import Exceptions.ItemsOverLimitException;
import payment.PaymentMethod;

import java.util.*;

public class Order extends OrderProcessorTemplate {

    private List<OrderItem> orderList = new ArrayList<>();
    private Set<Integer> itemId = new HashSet<>();
    private Map<Integer, OrderItem> orderMap = new HashMap<>();
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
        orderMap.put(orderItem.getId(),orderItem);

        return true;
    }

    public String getAllOrderedItems() {
        StringBuilder result = new StringBuilder();
        for (OrderItem order : orderList) {
            result.append(order.toString()).append("\n");
        }

        return result.toString();
    }

    public Optional<OrderItem> findById(int id) {
        if (itemId.contains(id)) return Optional.of(orderMap.get(id));
        return Optional.empty();
    }

    public void pay() {

    }
}
