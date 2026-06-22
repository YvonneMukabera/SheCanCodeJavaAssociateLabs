package com.java.backend.week1advancedjavaandcorefoundations.realtimeordermatchingengine3;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;

public class OrderBook {

    private final ConcurrentLinkedQueue<Order> buyOrders =
            new ConcurrentLinkedQueue<>();

    private final ConcurrentLinkedQueue<Order> sellOrders =
            new ConcurrentLinkedQueue<>();

    private final ReentrantLock lock =
            new ReentrantLock();

    public void addOrder(Order order) {

        lock.lock();
        try {

            if ("BUY".equals(order.getType())) {
                buyOrders.add(order);
            } else if ("SELL".equals(order.getType())) {
                sellOrders.add(order);
            }

        } finally {
            lock.unlock();
        }
    }

    public void matchOrders() {

        lock.lock();
        try {

            while (!buyOrders.isEmpty()
                    && !sellOrders.isEmpty()) {

                Order buy = buyOrders.poll();//to remove the first element from the queue
                Order sell = sellOrders.poll();

                System.out.println(
                        "MATCHED -> "
                                + buy.getOrderId()
                                + " with "
                                + sell.getOrderId()
                );
            }

        } finally {
            lock.unlock();
        }
    }

    // UPDATED RETURN TYPE TO MATCHRESULT2
    public MatchResult2 matchOrdersWithResult() {

        lock.lock();
        try {

            int matches = 0;

            while (!buyOrders.isEmpty()
                    && !sellOrders.isEmpty()) {

                buyOrders.poll();
                sellOrders.poll();

                matches++;
            }

            return new MatchResult2(matches);

        } finally {
            lock.unlock();
        }
    }

    public int getBuyOrderCount() {
        return buyOrders.size();
    }

    public int getSellOrderCount() {
        return sellOrders.size();
    }
}
