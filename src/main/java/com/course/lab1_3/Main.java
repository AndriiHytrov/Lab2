package com.course.lab1_3;

import com.course.lab1_3.analyzer.Analyzer;
import com.course.lab1_3.fillers.Fillers;
import com.course.lab1_3.output.Output;
import com.course.lab1_3.reflection.Reflection;
import com.course.lab1_3.sorters.ArrayDivision;
import com.course.lab1_3.sorters.MergeArraySort;
import com.course.lab1_3.sorters.MergeQuickSort;
import com.course.lab1_3.sorters.Sorters;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Reflection reflection = new Reflection();
        try {
            reflection.doYourWork(7);
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        List<int[]> arraysList = new ArrayList<>();
    }
}
