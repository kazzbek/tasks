package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        while (fileReader.ready()){
            fileReader.read();
            if(fileReader.ready())
                fileWriter.write(fileReader.read());
        }
        fileReader.close();
        fileWriter.close();
    }
}
