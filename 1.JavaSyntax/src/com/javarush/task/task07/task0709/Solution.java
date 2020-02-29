package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String minL;
        for (int i = 0; i < 5; i++) {
            list.add(reader.readLine());
        }

        minL=list.get(0);
        for (String s:list
             ) {
            if(minL.length()>s.length())
                minL=s;
        }

        for (String s:list
             ) {
            if(minL.length()==s.length())
                System.out.println(s);

        }
    }
}
