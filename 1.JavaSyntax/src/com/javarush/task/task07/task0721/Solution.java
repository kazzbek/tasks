package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i]=Integer.parseInt(reader.readLine());
        }

        int maximum=max(arr);
        int minimum=min(arr);

        //напишите тут ваш код

        System.out.print(maximum + " " + minimum);
    }

    public static int max(int[] arr){
        int max;
        max=arr[0];
        for (int i:arr
             ) {
            if(max<i){max=i;}
        }
        return max;
    }

    public static int min(int[] arr){
        int min;
        min=arr[0];
        for (int i:arr
             ) {
            if(min>i){min=i;}
        }
        return min;
    }
}
