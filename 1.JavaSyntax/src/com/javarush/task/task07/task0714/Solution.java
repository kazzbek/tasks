package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        list.add(0,reader.readLine());
        list.add(0,reader.readLine());
        list.add(0,reader.readLine());
        list.add(0,reader.readLine());
        list.add(0,reader.readLine());
        list.remove(2);

        for (String s: list
             ) {
            System.out.println(s);
        }
    }
}


