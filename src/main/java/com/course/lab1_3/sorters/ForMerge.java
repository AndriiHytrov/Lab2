package com.course.lab1_3.sorters;

import java.util.Arrays;

public abstract class ForMerge extends Sorters {

    protected void doMergeSort(int[] array, Sorters sorters){
        int[] firstSubarray = Arrays.copyOfRange(array, 0, array.length / 2);
        int[] secondSubarray = Arrays.copyOfRange(array, array.length / 2, array.length);

//        for(int i = 0; i < firstSubarray.length; i++){
//            System.out.println("f1: " + firstSubarray[i]);
//        }
//        for(int i = 0; i < secondSubarray.length; i++){
//            System.out.println("f2: " + secondSubarray[i]);
//        }
        if(Runtime.getRuntime().availableProcessors() < 2){
            sorters.sortArray(firstSubarray);
            sorters.sortArray(secondSubarray);
        }else {
            Runnable runnable_1 = new SortSubArray(firstSubarray, sorters);
            Runnable runnable_2 = new SortSubArray(secondSubarray, sorters);

            Thread thread_1 = new Thread(runnable_1);
            Thread thread_2 = new Thread(runnable_2);

            thread_1.start();
            thread_2.start();
        }
//        for(int i = 0; i < firstSubarray.length; i++){
//            System.out.println("f1: " + firstSubarray[i]);
//        }
//        for(int i = 0; i < secondSubarray.length; i++){
//            System.out.println("f2: " + secondSubarray[i]);
//        }
        doMerge(array, firstSubarray, secondSubarray);
//        for(int i = 0; i < array.length; i++){
//            System.out.println("\t\tf3: " + array[i]);
//        }
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
