package com.javarush.task.task22.task2202;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null)
            throw new TooShortStringException();

        Pattern p = Pattern.compile("\\s([\\S]+\\s[\\S]+\\s[\\S]+\\s[\\S]+)");
        Matcher m = p.matcher(string);
        if(m.find()){
            return m.group(1);
        }
        throw new TooShortStringException();
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
