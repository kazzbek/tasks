package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
*/

public class Solution {
    private static List<String> strings = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        strings.add(reader.readLine());
        strings.add(reader.readLine());
        strings.add(reader.readLine());
        strings.add(reader.readLine());
        strings.add(reader.readLine());

        int maxL;
        maxL= strings.get(0).length();

        for (String s:strings
             ) {
            maxL=maxL>s.length() ? maxL : s.length();
        }

        for (String s:strings
             ) {
            if (s.length()==maxL)
                System.out.println(s);
        }

    }
}
