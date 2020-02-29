package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        //args = new String[]{"z"};
        try {
            checkNum(args[0]);
        } catch (Exception e) {

        }
    }

    private static void checkNum(String arg) {
        BigInteger bi;
        for (int i = 2; i <=36 ; i++) {
            try {
                bi = new BigInteger(arg,i);
            } catch (Exception e) {
                continue;
            }
            System.out.println(i);
            return;
        }

        System.out.println("incorrect");
    }
}