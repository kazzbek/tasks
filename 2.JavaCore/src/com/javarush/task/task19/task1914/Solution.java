package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();



        System.setOut(consoleStream);
        Pattern pattern = Pattern.compile("(\\d+)\\s([+*-])\\s(\\d+)\\s=\\s");
        String str = outputStream.toString().replaceAll("\n|\r","");
        Matcher m = pattern.matcher(str);
        m.matches();
        String re;
        re = m.group(0);
        int a = Integer.parseInt(m.group(1));
        int b = Integer.parseInt(m.group(3));
        int c = 0;
        switch (m.group(2)) {
            case "-":
                c = a - b;
                break;
            case "*":
                c = a * b;
                break;
            case "+":
                c = a + b;
                break;
        }
        re += c;

        System.out.println(re);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }


}

