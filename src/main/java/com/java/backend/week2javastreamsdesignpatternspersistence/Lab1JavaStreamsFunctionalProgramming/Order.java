package com.java.backend.week2javastreamsdesignpatternspersistence.Lab1JavaStreamsFunctionalProgramming;

import java.util.List;

public class Order {
    private String orderId;
    private String status;
    private List<LineItem> lineItems;
    public Order(String orderId,String status,List<LineItem> lineItems) {
        this.orderId = orderId;
        this.status = status;
        this.lineItems = lineItems;
    }
    public String getOrderId() {
        return orderId;
    }
    public List<LineItem> getLineItems() {
        return lineItems;
    }
    public String getStatus() {
        return status;
    }


}
