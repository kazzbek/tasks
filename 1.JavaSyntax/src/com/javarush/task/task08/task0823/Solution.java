package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] a = s.toCharArray();
        for (int i = 1; i < a.length; i++) {
            if (a[i-1]==' '){
                a[i]=Character.toUpperCase(a[i]);
            }
        }
        a[0]=Character.toUpperCase(a[0]);
        s=new String(a);
        System.out.println(s);
        //напишите тут ваш код
    }
}
