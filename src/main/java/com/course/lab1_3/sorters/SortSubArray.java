package com.course.lab1_3.sorters;

import java.util.Arrays;

public class SortSubArray implements Runnable {

    protected int[] array;
    protected Sorters sorters;

    public SortSubArray(int[] array, Sorters sorters) {
        this.array = array;
        this.sorters = sorters;
    }

    @Override
    public void run() {
        sorters.sortArray(array);
    }
}
