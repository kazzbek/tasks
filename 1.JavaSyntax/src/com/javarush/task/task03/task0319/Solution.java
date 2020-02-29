package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();

        String sNum = reader.readLine();
        int a = Integer.parseInt(sNum);

        sNum = reader.readLine();
        int b = Integer.parseInt(sNum);
        System.out.println(name + " получает " + a + " через " + b + " лет.");
    }
}
