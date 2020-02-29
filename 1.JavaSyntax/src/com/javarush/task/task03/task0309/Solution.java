package com.javarush.task.task03.task0309;

/* 
Сумма 5 чисел
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Sum(5);
    }

    public static void Sum(int s) {
        int sum=0;
        for(int i=1;i<=s;i++)
        {
            sum+=i;
            System.out.println(sum);
        }
    }
}
