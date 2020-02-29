package com.javarush.task.task22.task2212;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null)
            return false;

        int countOfDig = 0;
        int countOfDif = 0;
        int countOfLeft = 0;
        int countOfRight = 0;

        Pattern p = Pattern.compile("\\d");
        Matcher m = p.matcher(telNumber);
        while (m.find()) {
            countOfDig++;
        }
        if (countOfDig < 10 || countOfDig > 12)
            return false;

            //1
            if (telNumber.substring(0, 1).equals("+") && countOfDig != 12)
                return false;

        //2
        p = Pattern.compile("^\\d.*");
        m = p.matcher(telNumber);
        if ((m.matches() || telNumber.substring(0, 1).equals("(")) && countOfDig != 10)
            return false;

        //3
        p = Pattern.compile("-");
        m = p.matcher(telNumber);
        while (m.find()) {
            countOfDif++;
        }
        if (countOfDif > 2)
            return false;
        p = Pattern.compile("--");
        m = p.matcher(telNumber);
        if (m.find())
            return false;
        //4
        p = Pattern.compile("\\(");
        m = p.matcher(telNumber);
        while (m.find()) {
            countOfLeft++;
        }
        p = Pattern.compile("\\)");
        m = p.matcher(telNumber);
        while (m.find()) {
            countOfRight++;
        }
        if (countOfLeft > 1 || countOfRight > 1 || countOfLeft != countOfRight)
            return false;

        p = Pattern.compile("-.*\\)");
        m = p.matcher(telNumber);
        if (m.find())
            return false;

        //5
        if (countOfLeft == 1) {
            p = Pattern.compile("\\(\\d{3}\\)");
            m = p.matcher(telNumber);
            if (!m.find())
                return false;
        }
        //6
        p = Pattern.compile("[\\p{Alpha}]");
        m = p.matcher(telNumber);
        if (m.find())
            return false;

        //7
        if (!telNumber.matches(".{9,}\\d$"))
            return false;


        return true;
    }


    public static void main(String[] args) {
        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("050123-4567"));
        System.out.println(checkTelNumber("+38)050(1234567"));
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println(checkTelNumber("050ххх4567"));
        System.out.println(checkTelNumber("050123456"));
        System.out.println(checkTelNumber("(0)501234567"));
    }
}
