package com.course.lab1_3.sorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ForMerge extends Sorters {

    public void doMergeSort(int[] array, Sorters sorters) {

        int availableProcessors;
        int minNumberOfProcessors;
        minNumberOfProcessors = 2;

        if (Runtime.getRuntime().availableProcessors() > array.length) {
            availableProcessors = minNumberOfProcessors;
        } else {
            availableProcessors = Runtime.getRuntime().availableProcessors();
        }

        List<int[]> arraysList = new ArrayList<>();
        arrayDivision(array, arraysList, availableProcessors);

        for (int[] a : arraysList) {
            new Thread(new SortSubArray(a, sorters)).start();
        }
    }

    public void arrayDivision(int[] array, List<int[]> arraysList, int arrayNumber) {

        int procNum = arrayNumber;
        int[] arr1 = Arrays.copyOfRange(array, 0, array.length / 2);
        int[] arr2 = Arrays.copyOfRange(array, array.length / 2, array.length);
        if (arrayNumber > 2) {
            arrayDivision_1(arr1, arraysList, procNum / 2);
            arrayDivision_1(arr2, arraysList, procNum - procNum / 2);
        } else if (arrayNumber == 2){
            arraysList.add(arr1);
            arraysList.add(arr2);
        } else {
            arraysList.add(array);
        }

        int e = 0;
    }


    public void arrayDivision_1(int[] array, List<int[]> arraysList, int arrayNumber) {
        int startIndex = 0;
        int lastIndex = array.length / arrayNumber;

        for (int i = 1; i < arrayNumber; i++) {
            arraysList.add(Arrays.copyOfRange(array, startIndex, lastIndex));
            startIndex += array.length / arrayNumber;
            lastIndex += array.length / arrayNumber;
        }
        arraysList.add(Arrays.copyOfRange(array, startIndex, array.length));
        int u = 0;
    }

    private void doMerge(int[] array, int[] firstSubarray, int[] secondSubarray) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (j < firstSubarray.length && k < secondSubarray.length) {
            if (firstSubarray[j] < secondSubarray[k]) {
                array[i] = firstSubarray[j];
                i++;
                j++;

            } else {
                array[i] = secondSubarray[k];
                i++;
                k++;
            }
        }
        if (j < firstSubarray.length) {
            while (j < firstSubarray.length) {
                array[j + k] = firstSubarray[j];
                j++;
            }
        } else if (k < secondSubarray.length) {
            while (k < secondSubarray.length) {
                array[j + k] = secondSubarray[k];
                k++;
            }
        }
    }
}
