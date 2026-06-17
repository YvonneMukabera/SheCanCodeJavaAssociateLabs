package com.java.backend.InventoryManagementSystem1;

import java.util.*;
public class ProductComparatorTest3 {
    public static void main  (String[] args){
        List<Product> products = new ArrayList<>();
        //same category, different price
        products.add(new Product("P1", "Laptop", "Electronics", "300"));
        products.add(new Product("P2", "phone", "Electronics", "500"));
        //another category
        products.add(new Product("P3", "car", "Mechanic", "1000"));
        products.add(new Product("P4", "bike", "Mechanic", "9000"));
        products.add(new Product("P5", "tractor", "Mechanic", "9000"));
        //edge case: null price
        products.add(new Product("P6", "Unknown item", "Mechanic", null));

        System.out.println("\nProducts before sorting:");
        products.forEach(System.out::println);

        Comparator<Product> productComparator=
                Comparator.comparing(Product::getCategory)//first compare by category then compare by price
                        .thenComparing(Product::getPrice,Comparator.nullsLast(Comparator.nullsLast(Comparator.reverseOrder())));
        products.sort(productComparator);

        System.out.println("\nProducts after sorting:");
        products.forEach(System.out::println);


    }
}
