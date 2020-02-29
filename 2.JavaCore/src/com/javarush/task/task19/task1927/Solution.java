package com.javarush.task.task19.task1927;

/*
Контекстная реклама
*/

import java.io.*;
public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream system = new PrintStream(System.out);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        System.setOut(system);
        String[] line = outputStream.toString().split(System.lineSeparator());
        for(int i =0;i<line.length;i++){
            System.out.println(line[i]);
            if((i-1)%2==0){
                System.out.println("JavaRush - курсы Java онлайн");
            }
        }


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}

