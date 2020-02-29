package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String ii = reader.readLine();
        int i = Integer.parseInt(ii);
        if (i<0)
            i++;
        else if(i>0)
            i*=2;
        System.out.println(i);

    }

}