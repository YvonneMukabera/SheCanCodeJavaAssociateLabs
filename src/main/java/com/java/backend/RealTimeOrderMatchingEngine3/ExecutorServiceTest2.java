package com.java.backend.RealTimeOrderMatchingEngine3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceTest2 {// help to create threads not manually

    private static final int TOTAL_ORDERS = 10000;

    public static void main(String[] args) {

        double totalThroughput = 0;

        for (int run = 1; run <= 5; run++) {
            totalThroughput += executeBenchmark(run);
        }

        System.out.println("\n=================================");
        System.out.println("Average Throughput = " +
                (totalThroughput / 5) + " orders/sec");
    }

    private static double executeBenchmark(int runNumber) {

        OrderBook orderBook = new OrderBook();

        int poolSize =
                Runtime.getRuntime().availableProcessors();

        ExecutorService executor =
                Executors.newFixedThreadPool(poolSize);

        long startTime = System.nanoTime();// to measure how long code takes to run

        try {

            // ADD ORDERS
            for (int i = 0; i < TOTAL_ORDERS; i++) {

                orderBook.addOrder(
                        new Order("BUY-" + i, "BUY")
                );

                orderBook.addOrder(
                        new Order("SELL-" + i, "SELL")
                );
            }

            // TASKS
            List<Future<MatchResult2>> futures =
                    new ArrayList<>();

            for (int i = 0; i < poolSize; i++) {

                Future<MatchResult2> future =
                        executor.submit(
                                orderBook::matchOrdersWithResult
                        );

                futures.add(future);
            }

            int totalMatched = 0;

            for (Future<MatchResult2> future : futures) {

                try {

                    MatchResult2 result = future.get();
                    totalMatched += result.getMatchedOrders();

                } catch (ExecutionException e) {

                    System.out.println(
                            "Task failed: " + e.getCause()
                    );
                }
            }

            long endTime = System.nanoTime();

            double seconds =
                    (endTime - startTime) / 1_000_000_000.0;

            double throughput =
                    totalMatched / seconds;

            System.out.println("\nRun " + runNumber);
            System.out.println("Matched Orders: " + totalMatched);
            System.out.println("Time: " + seconds + " sec");
            System.out.println("Throughput: " + throughput + " orders/sec");

            return throughput;

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
            return 0;

        } finally {
            executor.shutdown();
        }
    }
}