package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even = 0;
    public static int odd = 0;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(reader.readLine());
        while (i != 0) {
            if ((i % 10)%2 != 0) {
                odd++;
            } else {
                even++;
            }
            i /= 10;
        }
        System.out.println("Even: " + even + " Odd: " + odd);
    }
}
