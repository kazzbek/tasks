package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum;
        int n = Integer.parseInt(reader.readLine());
        int i = Integer.parseInt(reader.readLine());
        maximum = i;

        for (int j = 0; j < n - 2; j++) {
            i = Integer.parseInt(reader.readLine());
            maximum = i > maximum ? i : maximum;
        }


        //напишите тут ваш код

        System.out.println(maximum);
    }
}
