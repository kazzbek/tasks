package com.javarush.task.task04.task0434;


/* 
Таблица умножения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int i = 1,j;
        while (i <= 10) {
            j=1;
            while (j <= 10) {
                int c = i*j;
                System.out.print(c + " ");
                j++;
            }
            i++;
            System.out.println();
        }
    }
}
