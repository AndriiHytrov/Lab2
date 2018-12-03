package com.course.lab1_3.sorters;

import java.util.Arrays;

public class MergeBubbleUpSort extends ForMerge{

    @Override
    public synchronized void sortArray(int[] array) {
        BubbleUpSort bubbleUpSort = new BubbleUpSort();
        doMergeSort(array, bubbleUpSort);
    }
}
