package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        reader.close();

        String linefromfile="";
        while (fileReader.ready()) {
            linefromfile += (char)fileReader.read();
        }
        fileReader.close();
        //[^a-zA-Z]
        //\W
        //\b
        int a = 0;
        for (String s: linefromfile.split("[^a-zA-Z]")) {
            if(s.equals("world"))a++;
        }

        System.out.println(a);
    }
}
