package com.course.lab1_3;

import com.course.lab1_3.analyzer.Analyzer;
import com.course.lab1_3.fillers.Fillers;
import com.course.lab1_3.reflection.Reflection;
import com.course.lab1_3.sorters.MergeQuickSort;
import com.course.lab1_3.sorters.Sorters;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) {


//        Reflection reflection = new Reflection();
//        try {
//            reflection.doYourWork(30);
//        } catch (IllegalAccessException | InstantiationException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }


        int[] a = {12, 3, 4, 6, 9 , 4, 31, 0, -1};
        Sorters sorters = new MergeQuickSort();
        sorters.sortArray(a);
    }
}
