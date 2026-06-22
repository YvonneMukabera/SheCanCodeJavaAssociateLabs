package com.java.backend.week1advancedjavaandcorefoundations.realtimeordermatchingengine3;

public class Order {

    private String orderId;
    private String type;

    public Order(String orderId, String type) {
        this.orderId = orderId;
        this.type = type;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
