package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int a = Integer.parseInt(s);
        if(a>0 && a<1000) {
            if (a % 2 == 0)
                System.out.print("четное ");
            else
                System.out.print("нечетное ");

            switch (s.length()) {
                case 1:
                    System.out.print("однозначное число");
                    break;
                case 2:
                    System.out.print("двузначное число");
                    break;
                case 3:
                    System.out.print("трехзначное число");
                    break;
            }
        }

    }
}
