package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int arr[] = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(arr);

        for (int a : arr) {
            System.out.println(a);
        }

        //напишите тут ваш код
    }
}
