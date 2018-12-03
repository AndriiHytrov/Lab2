package com.course.lab1_3.sorters;

import java.util.Arrays;

public class MergeBubbleDownSort extends ForMerge{

    @Override
    public synchronized void sortArray(int[] array) {
        BubbleDownSort bubbleDownSort = new BubbleDownSort();
        doMergeSort(array, bubbleDownSort);
    }
}
