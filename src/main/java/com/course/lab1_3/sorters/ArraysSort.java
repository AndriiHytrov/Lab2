package com.course.lab1_3.sorters;

import java.util.Arrays;

public class ArraysSort extends Sorters{

    @Override
    public synchronized void sortArray(int[] array) {
        Arrays.sort(array);
    }
}
