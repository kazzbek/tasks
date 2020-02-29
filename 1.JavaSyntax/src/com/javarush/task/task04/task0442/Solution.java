package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(reader.readLine());
        int sum = i;

        while (i!=-1){
            i = Integer.parseInt(reader.readLine());
            sum+=i;
        }
        System.out.println(sum);
    }
}
