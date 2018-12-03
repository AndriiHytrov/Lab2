package com.course.lab1_3.reflection;
import com.course.lab1_3.analyzer.Analyzer;
import com.course.lab1_3.fillers.AnotationFiller;
import com.course.lab1_3.fillers.Fillers;
import com.course.lab1_3.output.Output;
import com.course.lab1_3.sorters.Sorters;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Reflection {

    private Fillers fillers = new Fillers();
    private Analyzer analyzer = new Analyzer();
    private Output output = new Output();

    private List<Method> methodsList = new ArrayList<>();
    private List<Class> classSortList = new ArrayList<>();


    public void doYourWork(int length) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        getHeirClass();
        getAnnotationMethods();
        for(Method method: methodsList){
            for(Class cl: classSortList){
                output.doPrint((Sorters) cl.newInstance(),
                        analyzer.SortTimeAnalyzer((int[])method.invoke(fillers, length), (Sorters) cl.newInstance()));
            }
        }
    }

    private void getAnnotationMethods(){

        Class aClass = fillers.getClass();
        Method[] methods = aClass.getDeclaredMethods();

        for(Method method:methods) {
            if(method.isAnnotationPresent(AnotationFiller.class)) {
                methodsList.add(method);
            }
        }
    }

    private void getHeirClass() {
        Reflections reflections = new Reflections("com.course.lab1_3.sorters");
        Set<Class<?extends Sorters>> childClass = reflections.getSubTypesOf(Sorters.class);
        for(Class c: childClass) {
            if (findParent(c) == null) {
                continue;
            }
            classSortList.add(findParent(c));
        }
    }

    private Class findParent(Class c) {
        Class clazz = c.getSuperclass();
        while (!clazz.equals(Sorters.class)) {
            clazz = clazz.getSuperclass();
        }
        if (clazz.equals(Sorters.class)) {
            if (Modifier.isAbstract(c.getModifiers())) {
                return null;
            }
        } else {
            findParent(clazz);
        }
        return c;
    }
}
