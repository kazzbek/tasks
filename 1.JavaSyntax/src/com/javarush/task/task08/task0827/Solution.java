package com.javarush.task.task08.task0827;

import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("January 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        Date dDate = new Date(date);
        Date startofYear = new Date(dDate.getYear(), 0, 1);
        long dif = dDate.getTime() - startofYear.getTime();
        int days = (int) (dif / 24 / 60 / 60 / 1000)+1;
        //System.out.println(days);
        return days % 2 == 0 ? false : true;
    }
}
