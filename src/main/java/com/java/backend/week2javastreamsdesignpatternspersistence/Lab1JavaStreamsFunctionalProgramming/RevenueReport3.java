package com.java.backend.week2javastreamsdesignpatternspersistence.Lab1JavaStreamsFunctionalProgramming;

public class RevenueReport3 {

    private double totalRevenue;
    private int itemCount;
    private double maxSingleItemRevenue;

    public RevenueReport3() {
        this.totalRevenue = 0;
        this.itemCount = 0;
        this.maxSingleItemRevenue = 0;
    }

    public void add(LineItem item) {

        double revenue = item.getPrice() * item.getQuantity();

        totalRevenue += revenue;
        itemCount++;
        maxSingleItemRevenue = Math.max(maxSingleItemRevenue, revenue);
    }
//ex2.3
    public void merge(RevenueReport3 other) {
        this.totalRevenue += other.totalRevenue;
        this.itemCount += other.itemCount;
        this.maxSingleItemRevenue =
                Math.max(this.maxSingleItemRevenue, other.maxSingleItemRevenue);
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public int getItemCount() {
        return itemCount;
    }

    public double getMaxSingleItemRevenue() {
        return maxSingleItemRevenue;
    }
}
