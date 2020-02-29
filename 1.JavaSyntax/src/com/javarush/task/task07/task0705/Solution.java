package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] big = new int[20];
        int[] min1 = new int[10];
        int[] min2 = new int[10];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < big.length; i++) {

            if (i < big.length / 2)
                min1[i] = big[i] = Integer.parseInt(reader.readLine());
            else
                min2[i-10] = big[i] = Integer.parseInt(reader.readLine());

        }

        for (int a: min2
             ) {
            System.out.println(a);

        }
    }
}
