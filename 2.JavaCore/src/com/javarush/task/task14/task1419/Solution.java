package com.javarush.task.task14.task1419;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        int[] ints = {1};
        try {
            System.out.println(ints[1]);
        } catch (Exception e) {
            exceptions.add(e);
        }

        ints = null;
        try {
            Arrays.sort(ints);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            A a = new A();
            B b = (B)a;
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            if(true)
            throw new Ex5();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            if(true)
            throw new Ex6();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            if(true)
            throw new Ex7();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            if(true)
            throw new Ex8();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            if(true)
            throw new Ex9();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            if(true)
            throw new Ex10();
        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

    }

    public static class A {}
    public static class B extends A{
        public void tets(){}
    }

    static class Ex5 extends Exception{}
    static class Ex6 extends Exception{}
    static class Ex7 extends Exception{}
    static class Ex8 extends Exception{}
    static class Ex9 extends Exception{}
    static class Ex10 extends Exception{}
}
