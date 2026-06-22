package com.java.backend.week1advancedjavaandcorefoundations.inventorymanagementsystem1;

public class Product {
    private String id;
    private String name;
    private String category;
    private double price;

    public Product(String id, String name, String category, String price) {
        this.id = id;
        this.name = name;
        this.category = category;
         if(price != null){
             this.price = Double.parseDouble(price);
         }
         else{
            this.price = 0;
         }
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }
    public double getPrice() {
        return price;
    }
@Override
    public String toString() {
        return String.format(
                "[%s. %s // %s // $%.2f]",id,name,category,price);
    }

}
