package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();

        String linefromfile = "";
        while (fileReader.ready()) {
            linefromfile += fileReader.readLine();
        }
        fileReader.close();


        linefromfile = linefromfile.replaceAll("(\\d+)?[^\\d\\s]+(\\d+)?", "");
        linefromfile.trim();

        linefromfile = linefromfile.replaceAll("\\s\\s+"," ");


        fileWriter.write(linefromfile);
        fileWriter.close();

/*        Pattern regexp = Pattern.compile("\\b(\\d+)\\b");
        Matcher m = regexp.matcher("12 text var2 14 8ю 1");
        boolean b = m.find();
        b = m.find();

        System.out.println(b);
        //  System.out.println(m.groupCount());
        while (m.find()) {
            System.out.println(m.group(1));
        }*/
    }
}
