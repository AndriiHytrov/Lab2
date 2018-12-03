package com.course.lab1_3.sorters;

import java.util.Arrays;

public class MergeQuickSort extends ForMerge{

    @Override
    public synchronized void sortArray(int[] array) {
        QuickSort quickSort = new QuickSort();
        doMergeSort(array, quickSort);
    }
}
