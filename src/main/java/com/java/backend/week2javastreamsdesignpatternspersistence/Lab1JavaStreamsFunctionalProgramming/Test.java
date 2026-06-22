package com.java.backend.week2javastreamsdesignpatternspersistence.Lab1JavaStreamsFunctionalProgramming;

import java.util.*;


public class Test {
    public static void main(String[] args) {
        Order order1 = new Order(
                "ORD001",
                "DELIVERED",
                List.of(
                        new LineItem("p001","Laptop", "Electronics", 1000,3),
                        new LineItem("p002","Mouse", "Electronics", 120,45),
                        new LineItem("p003","Novel", "Books", 500,10)
                )
        );
        Order order2 = new Order(
                "ORD002",
                "DELIVERED",
                List.of(
                        new LineItem("p004","Pen", "Learning material", 100,2),
                        new LineItem("p005","Monitor", "Electronics", 120,45),
                        new LineItem("p006","Batteries", "Electronics", 800,10)
                        )
        );
        Order order3 = new Order(
                "ORD003",
                "PENDING",
                List.of(
                        new LineItem("p007","Backpack", "Accessories", 60,6),
                        new LineItem("p008","Mouse", "Electronics", 120,45),
                        new LineItem("p009","Water Bottle", "Accessories", 25,9)
                        )

        );
        System.out.println("\nExercise 2.1: Stream Pipeline for Product Analytics");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        List<Order> orders= List.of(order1,order2,order3);
        System.out.println("\nAll items:");


        List<LineItem> allItems= ProductAnalytics.getAllLineItems(orders);
        allItems.stream()
                .map(LineItem::getPName)
                .distinct()
                .forEach(System.out::println);


        //total revenue
        double totalRevenue= ProductAnalytics.calculateTotalRevenue(orders);
        System.out.println("\nTotal revenue of those with quantity greater than 5: $"+totalRevenue);

        //n product with toppest revenue
        int n= 5;
        System.out.println("\nTop "+n+" products with highest revenue:");
        List<Map.Entry<String,Double>> topProducts=
                ProductAnalytics.topNProductByRevenue(orders,n);

        for(Map.Entry<String,Double>entry:topProducts){
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }
        //ex 2.2
        System.out.println("\nExercise 2.2: Collectors & Grouping");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
        System.out.println("Category count :");
        Map<String,Long> categoryCount= ProductAnalytics.groupItemsByCategory(orders);
        categoryCount.forEach((k,v)->System.out.println(k+"->"+v));
        System.out.println("\nOrder Partitioning:(true->delivered,false->pending)");
        Map<Boolean,List<Order>> partitionedOrders= ProductAnalytics.partitionOrders(orders);
        partitionedOrders.forEach((k,v)->System.out.println(k+"->"+v.size()));
        System.out.println("\nAVERAGE PRICE MAP");
        System.out.println(ProductAnalytics.productAveragePrice(orders));
        //ex2.3
        System.out.println("\n 2.3: Custom Collector & Parallel Streams");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
        RevenueReport3 report = orders.stream()
                .flatMap(o -> o.getLineItems().stream())
                .collect(LineItemCollector3.toRevenueReport());

        System.out.println("Total Revenue: " + report.getTotalRevenue());
        System.out.println("Item Count: " + report.getItemCount());
        System.out.println("Max Item Revenue: " + report.getMaxSingleItemRevenue());

        //sequence and parallel
        var seq = ProductAnalytics.topNProductsByRevenueSequential(orders, 2);
        var par = ProductAnalytics.topNProductsByRevenueParallel(orders, 2);

        System.out.println("\nSEQ: " + seq);
        System.out.println("PAR: " + par);
    }
}
