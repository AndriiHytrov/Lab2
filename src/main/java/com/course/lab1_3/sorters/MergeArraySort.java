package com.course.lab1_3.sorters;

import java.util.Arrays;

public class MergeArraySort extends ForMerge{

    @Override
    public synchronized void sortArray(int[] array) {
        ArraysSort arraysSort = new ArraysSort();
        doMergeSort(array, arraysSort);
    }
}