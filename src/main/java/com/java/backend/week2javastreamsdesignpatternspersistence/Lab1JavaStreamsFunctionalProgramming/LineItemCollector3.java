package com.java.backend.week2javastreamsdesignpatternspersistence.Lab1JavaStreamsFunctionalProgramming;

import java.util.stream.Collector;

public class LineItemCollector3 {

    public static Collector<LineItem, RevenueReport3, RevenueReport3> toRevenueReport() {

        return Collector.of(

                // supplier
                RevenueReport3::new,

                // accumulator
                RevenueReport3::add,

                // combiner (for parallel streams)
                (r1, r2) -> {
                    r1.merge(r2);
                    return r1;
                },

                Collector.Characteristics.UNORDERED
        );
    }
}
