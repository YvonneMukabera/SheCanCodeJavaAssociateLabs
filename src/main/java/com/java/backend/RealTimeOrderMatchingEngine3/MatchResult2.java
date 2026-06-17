package com.java.backend.RealTimeOrderMatchingEngine3;

public class MatchResult2 {

    private final int matchedOrders;// value will not be changed once initialized

    public MatchResult2(int matchedOrders) {
        this.matchedOrders = matchedOrders;
    }

    public int getMatchedOrders() {
        return matchedOrders;
    }

    @Override
    public String toString() {

        return "Matched Orders = " + matchedOrders;
    }
}