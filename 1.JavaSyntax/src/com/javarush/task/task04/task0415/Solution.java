package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int a = Integer.parseInt(s);
        s = reader.readLine();
        int b = Integer.parseInt(s);
        s = reader.readLine();
        int c = Integer.parseInt(s);
        if (a < b + c & b < a + c & c < a + b)
            System.out.println("Треугольник существует.");
        else
            System.out.println("Треугольник не существует.");
    }
}