package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        HashMap<String, Integer> monthtoint = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12; i++) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMMMM", Locale.ENGLISH);
            Date date = new Date(2012, i, 01);
            monthtoint.put(dateFormat.format(date), i + 1);
        }
        String s = reader.readLine();

        System.out.println(s + " is the "+ monthtoint.get(s) + " month");

    }
}
