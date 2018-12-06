package com.course.lab1_3.sorters;

import java.util.Arrays;
import java.util.List;

public class ArrayDivision {

    protected void arrayDivisionWithRec(int[] array, List<int[]> arraysList, int arrayNumber) {

        int[] arr1 = Arrays.copyOfRange(array, 0, array.length / 2);
        int[] arr2 = Arrays.copyOfRange(array, array.length / 2, array.length);

        if (arrayNumber > 2) {
            arrayDivision(arr1, arraysList, arrayNumber / 2);
            arrayDivision(arr2, arraysList, arrayNumber - arrayNumber / 2);
        } else if (arrayNumber == 2){
            arraysList.add(arr1);
            arraysList.add(arr2);
        } else {
            arraysList.add(array);
        }
    }

    protected void arrayDivision(int[] array, List<int[]> arraysList, int arrayNumber) {
        int startIndex = 0;
        int lastIndex = array.length / arrayNumber;

        for (int i = 1; i < arrayNumber; i++) {
            arraysList.add(Arrays.copyOfRange(array, startIndex, lastIndex));
            startIndex += array.length / arrayNumber;
            lastIndex += array.length / arrayNumber;
        }
        arraysList.add(Arrays.copyOfRange(array, startIndex, array.length));
    }

}
