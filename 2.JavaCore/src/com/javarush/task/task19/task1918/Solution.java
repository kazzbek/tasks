package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static String firstTEG;

    public static void main(String[] args) throws IOException {

        InputStream SYSIN = new ByteArrayInputStream("E:\\testFiles\\HTML.html".getBytes());
        System.setIn(SYSIN);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);

        String stringFile = "";

        while (br.ready()) {
            stringFile += (char) br.read();
        }
        br.close();
        //System.out.println(stringFile);


        Pattern p = Pattern.compile("<(\\w+)");
        Matcher m = p.matcher(stringFile);


        m.find();

        firstTEG = args[0];
        splitTAG(stringFile);

    }

    public static void splitTAG(String str) {
        String reg = "((<" + firstTEG + ")|(</" + firstTEG + ">))";
        Pattern pstart = Pattern.compile(reg);
        Matcher matcher = pstart.matcher(str);


        while (matcher.find()) {//если хотябы один
            int countS = 0;
            int countE = 0;
            int start = 0;
            int end = 0;
            while (!matcher.group(1).equals("<" + firstTEG)){
                if(!matcher.find()){
                    return;
                }
            }


            start = matcher.start();
            while (true) {
                if (matcher.group(1).equals("<" + firstTEG)) {
                    countS++;
                } else {
                    countE++;
                    end = matcher.end();
                }
                matcher.find();
                if (countE == countS) {
                    //System.out.println();
                    System.out.println(str.substring(start, end).replaceAll("\n|\r",""));
                    String rec = str.substring(start + firstTEG.length() + 1, str.length());
                    str = rec;
                    matcher = pstart.matcher(rec);
                    break;
                }
            }

        }


    }
}
