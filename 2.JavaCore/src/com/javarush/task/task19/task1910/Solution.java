package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws  IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(file1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file2));
        reader.close();

        String temp = "";

        while (fileReader.ready()){
            temp += (char)fileReader.read();
        }

        temp = temp.replaceAll("[saas>!\"\\#$%&'()*+,\\-./:;<=>?@\\[\\\\\\]^_`{|}~\\n]","");

        fileWriter.write(temp);



        fileReader.close();
        fileWriter.close();
    }
}
