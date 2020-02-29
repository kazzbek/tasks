package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        String str = readLine();
        str = str.substring(str.indexOf('?') + 1, str.length());//обрезаем строку
        List<String> lists = new ArrayList<>();
        lists.addAll(Arrays.asList(str.split("&")));
        String objStr = "";
        str = "";
        for (String s : lists) {
            if (s.startsWith("obj")) {
                objStr = s.substring(4);
            }
            if (s.contains("=")) {
                s = s.substring(0, s.indexOf("="));
            }
            str += s + " ";
        }
        //str = str.trim();
        System.out.println(str);
        if (!objStr.equals(""))
        newAlert(objStr);


    }

    public static void newAlert(String s) {
        try {
            alert(Double.parseDouble(s));
        } catch (NumberFormatException e) {
            alert(s);
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }

    public static String readLine() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ошибка";
    }

}
