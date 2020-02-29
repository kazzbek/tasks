package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();



        System.setOut(consoleStream);
        System.out.println(outputStream.toString());
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        FileOutputStream outputStream1 = new FileOutputStream(file);
        outputStream1.write(outputStream.toString().getBytes());
        outputStream1.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

