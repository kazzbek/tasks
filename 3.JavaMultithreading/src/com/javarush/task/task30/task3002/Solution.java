package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        //напишите тут ваш код
        String ret;
        String pref;
        int i = 0;
        pref = s.substring(0, 2);
        switch (pref) {
            case "0x":
                i = Integer.parseInt(s.substring(2), 16);
                return String.valueOf(i);
            case "0b":
                i = Integer.parseInt(s.substring(2), 2);
                return String.valueOf(i);
        }
        pref = s.substring(0, 1);
        if (pref.equals("0")) {
            i = Integer.parseInt(s.substring(1), 8);
            return String.valueOf(i);
        }
        i = Integer.parseInt(s, 10);
        return String.valueOf(i);
    }
}
