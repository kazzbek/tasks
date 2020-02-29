package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        // напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<Boolean> order = new ArrayList<>();

        for (String s: array) {
            if (isNumber(s)){
                integers.add(Integer.parseInt(s));
                order.add(true);
            }else{
                strings.add(s);
                order.add(false);
            }
        }
        Collections.sort(integers);
        Collections.reverse(integers);
        for (int i = 0; i < strings.size(); i++) {
        for (int j = i+1; j < strings.size(); j++) {
            if(isGreaterThan(strings.get(i),strings.get(j))){
                String s = strings.get(i);
                strings.set(i,strings.get(j));
                strings.set(j,s);
            }
        }
        }
        int istr=0;
        int iint=0;
        int i=0;
        for (boolean b: order) {
            if (b){
                array[i]=integers.get(iint).toString();
                iint++;
            }else {
                array[i]=strings.get(istr);
                istr++;
            }
            i++;
        }

    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
