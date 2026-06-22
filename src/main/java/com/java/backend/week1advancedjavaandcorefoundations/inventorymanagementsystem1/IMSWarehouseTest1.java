package com.java.backend.week1advancedjavaandcorefoundations.inventorymanagementsystem1;

public class IMSWarehouseTest1 {
    public static void main(String[] args) {
        WarehouseStore<Product> store = new WarehouseStore<>();
        store.addProduct(
                new Product("P1", "Laptop", "Electronics", "500")
        );
        store.addProduct(
                new Product("P2", "smartphone", "Electronics", "300")
        );
        store.addProduct(
                new Product("P3", "car", "Mechanic", "9000")
        );
        System.out.println("All Products:");
        for (Product product : store.getAllProducts()) {
            System.out.println(product);
        }
        System.out.println("Electronics Products:");
        for (Product product : store.searchByCategory("Electronics")) {
            System.out.println(product);
        }
        store.removeProduct("P1");
        System.out.println("After removing P1:");
        for (Product product : store.getAllProducts()) {
            System.out.println(product);
        }
        //for testing generic constraint rejects non-Product types at compile time.
        //WarehouseStore<Customer> customerStore= new WarehouseStore<>();
    }
}
