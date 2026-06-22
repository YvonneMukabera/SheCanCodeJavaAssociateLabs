package com.java.backend.week2javastreamsdesignpatternspersistence.Lab2DesignPatternsinPractice;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        // A simple list of numbers
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // ==================================================
        // 1. FILTER (keep only even numbers)
        // ==================================================
        List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        System.out.println("Even numbers: " + evens);

        // ==================================================
        // 2. MAP (transform each number)
        // ==================================================
        List<Integer> doubled = numbers.stream()
                .map(n -> n * 2)
                .toList();

        System.out.println("Doubled numbers: " + doubled);

        // ==================================================
        // 3. REDUCE (combine everything into one value)
        // ==================================================
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println("Sum of all numbers: " + sum);

        // ==================================================
        // 4. FOREACH (just print each element)
        // ==================================================
        System.out.println("Printing all numbers:");
        numbers.stream()
                .forEach(n -> System.out.println(n));
    }
}
