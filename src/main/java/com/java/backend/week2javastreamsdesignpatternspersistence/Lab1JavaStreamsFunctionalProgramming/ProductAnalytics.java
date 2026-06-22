package com.java.backend.week2javastreamsdesignpatternspersistence.Lab1JavaStreamsFunctionalProgramming;

import java.util.*;
import java.util.stream.Collectors;

public class ProductAnalytics {
    public static List<LineItem> getAllLineItems(List<Order>orders) {
        return orders.stream()
                .flatMap(order -> order.getLineItems().stream())
                .toList();
    }
    public static double calculateTotalRevenue(List<Order>orders){
        return orders.stream()
                .flatMap(order -> order.getLineItems().stream())
                .filter(item->item.getQuantity()>5)
                .mapToDouble(item->item.getQuantity()* item.getPrice())
                .reduce(0.0,Double::sum);
    }
    //to N product by revenue
    public static List<Map.Entry<String,Double>>
    topNProductByRevenue(List<Order>orders,int n) {
        return orders.stream()
                .flatMap(order -> order.getLineItems().stream())
                .collect(Collectors.groupingBy(
                                LineItem::getPName,
                                Collectors.summingDouble(item -> item.getPrice() * item.getQuantity())
                        )
                )
                .entrySet()
                .stream()
                .sorted(
                        Map.Entry.<String, Double>comparingByValue()
                                .reversed()
                )
                .limit(n)
                .toList();
    }
   //ex2
   public static Map<String, Long> groupItemsByCategory(List<Order> orders) {

       return orders.stream()
               .flatMap(order -> order.getLineItems().stream())
               .collect(Collectors.groupingBy(
                       LineItem::getCategory,
                       Collectors.counting()
               ));
   }
    public static Map<Boolean, List<Order>> partitionOrders(List<Order> orders) {

        return orders.stream()
                .collect(Collectors.partitioningBy(
                        order -> order.getStatus().equalsIgnoreCase("DELIVERED")
                ));
    }
    public static Map<String, Double> productAveragePrice(List<Order> orders) {

        return orders.stream()
                .flatMap(order -> order.getLineItems().stream())
                .collect(Collectors.toMap(
                        LineItem::getProductId,
                        LineItem::getPrice,
                        (price1, price2) -> (price1 + price2) / 2
                ));
    }
    //ex3
    // SEQUENTIAL
    public static List<Map.Entry<String, Double>>
    topNProductsByRevenueSequential(List<Order> orders, int n) {

        return orders.stream()
                .flatMap(o -> o.getLineItems().stream())
                .collect(Collectors.groupingBy(
                        LineItem::getPName,
                        Collectors.summingDouble(
                                i -> i.getPrice() * i.getQuantity()
                        )
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(n)
                .toList();
    }

    // PARALLEL
    public static List<Map.Entry<String, Double>>
    topNProductsByRevenueParallel(List<Order> orders, int n) {

        return orders.parallelStream()
                .flatMap(o -> o.getLineItems().stream())
                .collect(Collectors.groupingBy(
                        LineItem::getPName,
                        Collectors.summingDouble(
                                i -> i.getPrice() * i.getQuantity()
                        )
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(n)
                .toList();
    }


}
