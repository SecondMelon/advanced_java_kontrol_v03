package domain;

import java.util.Objects;

public class OrderItem {

    private final int id;
    private final String name;
    private final double price;

    public OrderItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {return id;}

    public boolean equals(OrderItem orderItem) {
        if (this == orderItem) return true;
        if (orderItem == null) return false;

        if (this.getId() != orderItem.getId()) return false;
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(id);
    }

    public String toString() {
        return ("Item ID: " + id + ", item name: " + name + ", item price: " + price);
    }
}
