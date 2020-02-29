package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        Date date = new Date();
        String str = reader.readLine();
        try {
            date = ft.parse(str);
            //System.out.println(date);
        }catch (Exception e) {
            System.out.println("Нераспаршена с помощью " + ft);
        }
        ft = new SimpleDateFormat ("MMM dd, yyyy", Locale.ENGLISH);
        System.out.println(ft.format(date).toUpperCase());

    }
}
