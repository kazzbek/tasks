package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<Integer> full = new ArrayList<>();
        ArrayList<Integer> a3 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++) {
            full.add(Integer.parseInt(reader.readLine()));
        }

        for (int i: full
             ) {
            if(i%3==0) a3.add(i);
            if(i%2==0) a2.add(i);
            if(i%2!=0 && i%3!=0) a.add(i);
        }
        printList(a3);
        printList(a2);
        printList(a);
    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for (int i : list
        ) {
            System.out.println(i);
        }
    }
}
