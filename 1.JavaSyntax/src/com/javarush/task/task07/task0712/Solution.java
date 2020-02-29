package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }
        int minL, maxL;
        minL = maxL = list.get(0).length();

        for (String s : list
        ) {
            if (minL > s.length())
                minL = s.length();
            if (maxL < s.length())
                maxL = s.length();
        }

        for (String s : list
        ) {
            if (s.length() == minL || s.length() == maxL) {
                System.out.println(s); break;
            }

        }

    }
}
