package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        double count = 0, i = 1, sum = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        while (i != -1) {
            i = Double.parseDouble(reader.readLine());
            if (i != -1) {
                count++;
                sum += i;
            }
        }
        if (count==0)
            count=1;
        System.out.println(sum/count);
    }
}

