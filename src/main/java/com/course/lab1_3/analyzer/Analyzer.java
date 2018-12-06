package com.course.lab1_3.analyzer;
/**
 * @author Andrii
 */

import com.course.lab1_3.fillers.Fillers;
import com.course.lab1_3.sorters.Sorters;

public class Analyzer {

    public long SortTimeAnalyzer(int[] array, Sorters sorters){

        int[] r;
        r = array;
        long before = System.nanoTime();
        sorters.sortArray(r);
        long after = System.nanoTime();
        for(int i = 0; i < array.length; i++){
            System.out.print(r[i] + " ");
        }
        return after - before;
    }
}
