package com.course.lab1_3.analyzer;

import com.course.lab1_3.sorters.Sorters;

public class Analyzer {

    public long SortTimeAnalyzer(int[] array, Sorters sort){
        long before = System.nanoTime();
        sort.sortArray(array);
        long after = System.nanoTime();
        return after - before;
    }
}
