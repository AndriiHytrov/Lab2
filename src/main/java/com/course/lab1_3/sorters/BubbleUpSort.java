package com.course.lab1_3.sorters;

public class BubbleUpSort extends BubbleSort{

    public BubbleUpSort(){
        setSortType("Bubble Up Sort");
    }


    @Override
    public void sortArray(int[] array) {
        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j]>array[j + 1]){
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }
}