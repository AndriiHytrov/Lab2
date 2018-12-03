package com.course.lab1_3.fillers;
import java.lang.annotation.Inherited;
import java.util.Random;

public class Fillers {

    @AnotationFiller(name = "backwardSortedArray")
    public static int[] backwardSortedArray(int length){
        int[] array = new int[length];
        for(int i = 0; i < array.length; i++){
            array[i] = array.length - i;
        }
        return array;
    }

    @Deprecated
    public void m(){

    }

    @AnotationFiller(name = "randomArray")
    public static int[] randomArray(int length){
        int[] array = new int[length];
        Random random = new Random();
        for(int i = 0; i < array.length; i++){
            array[i] = random.nextInt(100);
        }
        return array;
    }

    @AnotationFiller(name = "sortedArray")
    public static int[] sortedArray(int length){
        int[] array = new int[length];
        for(int i = 0; i < array.length; i++){
            array[i] = i + 1;
        }
        return array;
    }

    @AnotationFiller(name = "sortedArrayPlusOne")
    public static int[] sortedArrayPlusOne(int length){
        int[] array = new int[length];
        Random random = new Random();
        for(int i = 0; i < array.length - 1; i++){
            array[i] = i + 1;
        }
        array[array.length-1] = random.nextInt(100);
        return array;
    }
}






