package com.course.lab1_3.sorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class ForMerge extends Sorters {

    int availableProcessors;
    int minNumberOfProcessors = 2;
    ArrayDivision arrayDivision = new ArrayDivision();
    List<int[]> arraysList = new ArrayList<>();
    List<Thread> threadList = new ArrayList<>();

    public void doMergeSort(int[] array, Sorters sorters) {

        if (Runtime.getRuntime().availableProcessors() > array.length) {
            availableProcessors = minNumberOfProcessors;
        } else {
            availableProcessors = Runtime.getRuntime().availableProcessors();
        }

        arrayDivision.arrayDivision(array, arraysList, availableProcessors);


        for (int[] a : arraysList) {
            Thread thread = new Thread(new SortSubArray(a, sorters));
            threadList.add(thread);
            thread.start();
        }
        for(Thread t: threadList){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (arraysList.size() != 1){
            doMerge(arraysList, arraysList.get(0), arraysList.get(1));
        }
        for(int i = 0; i < arraysList.get(0).length; i++){
            array[i] = arraysList.get(0)[i];
        }
    }

    private void doMerge(List <int[]> arraysList, int[] firstSubarray, int[] secondSubarray) {

        int i = 0;
        int j = 0;
        int k = 0;
        int[] array = new int[firstSubarray.length + secondSubarray.length];

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
        arraysList.remove(firstSubarray);
        arraysList.remove(secondSubarray);
        arraysList.add(array);
    }
}
