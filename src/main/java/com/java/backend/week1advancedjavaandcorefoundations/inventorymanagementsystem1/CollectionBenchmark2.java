package com.java.backend.week1advancedjavaandcorefoundations.inventorymanagementsystem1;
import java.util.*;
public class CollectionBenchmark2 {
    private static final int SIZE = 1000;
    public static void main(String[] args) {
        testCollection(
                new ArrayList<>(),"ArrayList");
        testCollection(

                new LinkedList<>(),"LinkedList");
        testCollection(

                new HashSet<>(),"HashSet");
        testCollection(new TreeSet<>(),"TreeSet");

    }
    public static void testCollection(Collection<String> collection, String name) {
        System.out.println("\n//Testing " + name);
        benchmarkInsertion(collection);
        benchmarkLookup(collection);
        benchmarkIteration(collection);

    }
    private static void benchmarkInsertion(Collection<String> collection){
        long start = System.nanoTime();
        for(int i =1; i<=SIZE; i++){
            collection.add("SKU-"+i);
        }
        long end = System.nanoTime();
        System.out.println("Insertion time: " + (end - start) + " ns");
    }
    private static void benchmarkLookup(Collection<String> collection){
        long start = System.nanoTime();
            collection.contains("SKU-500");
        long end = System.nanoTime();
        System.out.println("Lookup time: " + (end - start) + " ns");
    }
    private static void benchmarkIteration(Collection<String> collection){
        long start= System.nanoTime();
        Iterator<String> iterator = collection.iterator();
        while(iterator.hasNext()){
            iterator.next();
        }
        long end = System.nanoTime();
        System.out.println("Iteration time: " + (end - start) + " ns");
    }
}
