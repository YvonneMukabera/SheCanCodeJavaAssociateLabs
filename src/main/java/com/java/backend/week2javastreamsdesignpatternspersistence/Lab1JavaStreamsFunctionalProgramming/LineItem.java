package com.java.backend.week2javastreamsdesignpatternspersistence.Lab1JavaStreamsFunctionalProgramming;

public class LineItem {
    private String PName;
    private int quantity;
    private double price;
    private String productId;
    private String  category;


 public LineItem(String productId, String PName, String category,double price,int quantity) {
     this.productId = productId;
     this.PName = PName;
     this.category = category;
     this.price = price;
     this.quantity = quantity;

 }

 public String getProductId() {
        return productId;
    }
 public String getPName() {
     return PName;
 }
 public int getQuantity() {
     return quantity;
 }
 public double getPrice() {
     return price;
 }
 public String getCategory() {
     return category;
 }
}
