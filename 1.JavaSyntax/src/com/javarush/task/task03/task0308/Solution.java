package com.javarush.task.task03.task0308;

/* 
Произведение 10 чисел
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        System.out.println(Pro(10));
    }

    public static int Pro(int p) {
        int m=1;
        for(int i=2;i<=p;i++)
            m=m*i;
        return m;
    }
}
