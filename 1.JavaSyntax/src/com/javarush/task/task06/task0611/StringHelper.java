package com.javarush.task.task06.task0611;

/* 
Класс StringHelper
*/

public class StringHelper {
    public static String multiply(String s) {
        String result = multiply(s,5);
        //напишите тут ваш код
        return result;
    }

    public static String multiply(String s, int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result+=s;
        }
        //напишите тут ваш код
        return result;
    }

    public static void main(String[] args) {

    }
}
