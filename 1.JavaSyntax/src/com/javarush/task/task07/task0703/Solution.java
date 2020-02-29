package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] i = new int[10];
        String[] s = new String[10];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int j = 0; j < 10; j++) {
            s[j] = reader.readLine();
            i[j] = s[j].length();
        }

        for (int a: i) {
            System.out.println(a);

        }

    }
}
