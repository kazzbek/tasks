package com.javarush.task.task22.task2203;


/*
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException{
        try
        {
            int indtab1 = string.indexOf("\t");
            int indtab2 = string.indexOf("\t",indtab1+1);
            return string.substring( indtab1 + 1, indtab2 );
        }
        catch (Exception e) {

        throw new TooShortStringException();

        }
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
