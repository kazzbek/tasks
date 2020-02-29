package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here

        if (n > 0) {
            BigInteger bigInteger = BigInteger.valueOf(n);
            for (int i = n; i > 1; i--) {
                bigInteger = bigInteger.multiply(BigInteger.valueOf(i - 1));
            }
            return bigInteger.toString();
        } else if (n == 0)
            return "1";
        return "0";
    }
}
