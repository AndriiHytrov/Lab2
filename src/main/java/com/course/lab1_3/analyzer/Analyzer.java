package com.course.lab1_3.analyzer;
/**
 * @author Andrii
 */

import com.course.lab1_3.fillers.Fillers;
import com.course.lab1_3.sorters.Sorters;

public class Analyzer {

    public long SortTimeAnalyzer(int[] array, Sorters sorters){

        long before = System.nanoTime();
        sorters.sortArray(array);
        long after = System.nanoTime();

        return after - before;
    }
}
