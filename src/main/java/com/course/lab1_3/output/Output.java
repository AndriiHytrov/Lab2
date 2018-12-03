package com.course.lab1_3.output;

import com.course.lab1_3.analyzer.Analyzer;
import com.course.lab1_3.fillers.Fillers;
import com.course.lab1_3.sorters.*;

public class Output {

    public void doPrint(Sorters sorters, long time){

        Class clazz = sorters.getClass();
        System.out.println(clazz.getSimpleName() + ": " + time);
    }

}
