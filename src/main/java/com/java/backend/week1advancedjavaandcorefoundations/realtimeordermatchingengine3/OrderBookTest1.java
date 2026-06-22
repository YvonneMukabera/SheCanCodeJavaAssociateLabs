package com.java.backend.week1advancedjavaandcorefoundations.realtimeordermatchingengine3;

public class OrderBookTest1 {
    public static void main(String[] args)
            throws InterruptedException {

        OrderBook orderBook =
                new OrderBook();


        Thread[] buyers =
                new Thread[10];

        Thread[] sellers =
                new Thread[10];


        for (int i = 0; i < 10; i++) {

            int id = i;

            buyers[i] =
                    new Thread(() -> {

                        Order order =
                                new Order(
                                        "BUY-" + id,
                                        "BUY"
                                );

                        orderBook.addOrder(
                                order
                        );
                    });

            sellers[i] =
                    new Thread(() -> {

                        Order order =
                                new Order(
                                        "SELL-" + id,
                                        "SELL"
                                );

                        orderBook.addOrder(
                                order
                        );
                    });
        }


        for (Thread buyer : buyers) {
            buyer.start();
        }

        for (Thread seller : sellers) {
            seller.start();
        }


        for (Thread buyer : buyers) {
            buyer.join();
        }

        for (Thread seller : sellers) {
            seller.join();
        }


        System.out.println(
                "\nBefore Matching"
        );

        System.out.println(
                "Buy Orders: "
                        + orderBook.getBuyOrderCount()
        );

        System.out.println(
                "Sell Orders: "
                        + orderBook.getSellOrderCount()
        );


        orderBook.matchOrders();


        System.out.println(
                "\nAfter Matching"
        );

        System.out.println(
                "Buy Orders: "
                        + orderBook.getBuyOrderCount()
        );

        System.out.println(
                "Sell Orders: "
                        + orderBook.getSellOrderCount()
        );
    }
}
