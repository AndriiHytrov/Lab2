package com.course.lab1_3.sorters;

import java.util.Arrays;

public class ArraysSort extends Sorters{

    public ArraysSort(){
        setSortType("Arrays Sort");
    }
    @Override
    public void sortArray(int[] array) {
        Arrays.sort(array);
    }
}
