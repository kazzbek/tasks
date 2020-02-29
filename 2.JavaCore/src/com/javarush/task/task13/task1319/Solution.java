package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws Exception{
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new FileWriter(reader.readLine()));
        String s = reader.readLine();
        while (!s.equals("exit")){
            String lineSeparator = System.getProperty("line.separator");
            s+=lineSeparator;
            bw.write(s);
            s = reader.readLine();
        }
        bw.write(s);
        bw.close();
        reader.close();




    }

}
