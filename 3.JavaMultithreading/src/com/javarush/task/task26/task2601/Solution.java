package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
       /* System.out.println(Arrays.asList(sort(new Integer[]{13, 8, 15, 5, 17})));
        System.out.println("----------------------------------------------");
        System.out.println(Arrays.asList(sort(new Integer[]{13, 8, 15, 5, 17, 11})));
        System.out.println("----------------------------------------------");
        System.out.println(Arrays.asList(sort(new Integer[]{1,2,3,3,3,4,5})));
        System.out.println("----------------------------------------------");
        System.out.println(Arrays.asList(sort(new Integer[]{1,2,4,4,4,5})));
        System.out.println("----------------------------------------------");
        System.out.println(Arrays.asList(sort(new Integer[]{})));
        System.out.println("----------------------------------------------");
        System.out.println(Arrays.asList(sort(new Integer[]{0})));*/

    }

    public static Integer[] sort(Integer[] array) {
        if(array==null || array.length==0)
            return array;
        Arrays.sort(array);
        int median;
        if (array.length % 2 == 0)
            median = (array[array.length / 2 - 1] + array[array.length / 2 ]) / 2;
        else
            median = array[array.length / 2 ];
        Arrays.sort(array, Comparator.comparingInt(i -> Math.abs(i - median)));
        return array;
    }
}
