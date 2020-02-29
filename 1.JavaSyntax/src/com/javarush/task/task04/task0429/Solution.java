package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a, b = 0, c = 0;
        for (int i = 0; i < 3; i++) {
            a = Integer.parseInt(reader.readLine());
            if (a > 0)
                b++;
            if (a < 0)
                c++;
        }
        System.out.println("количество отрицательных чисел: " + c);
        System.out.println("количество положительных чисел: " + b);
    }
}
