package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }

        System.out.println(getMaxRepeatSet(list));

    }

    //считаем количество повторов подрят
    public static int getMaxRepeatSet(ArrayList<Integer> list) {
        int maxRepeatSet = 1;
        int curRepeatSet = 1;
        int current;
        int prew;
        for (int i = 1; i < list.size(); i++) {
            current = list.get(i);
            prew = list.get(i - 1);
            if (prew == current) {
                curRepeatSet++;
            } else {
                if (curRepeatSet > maxRepeatSet) {
                    maxRepeatSet = curRepeatSet;
                }
                curRepeatSet = 1;
            }
        }
        if (curRepeatSet > maxRepeatSet) {
            maxRepeatSet = curRepeatSet;
        }
        return maxRepeatSet;
    }
}