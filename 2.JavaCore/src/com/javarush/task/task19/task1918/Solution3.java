package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution3 {
    public static String firstTEG;

    public static void main(String[] args) throws IOException {
/*
        InputStream SYSIN = new ByteArrayInputStream("E:\\testFiles\\HTML.html".getBytes());
        System.setIn(SYSIN);
*/
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

        firstTEG = m.group(1);
        splitTAG(stringFile);

    }

    public static void splitTAG(String str) {
        String reg = "((<" + firstTEG + ")|(</" + firstTEG + ">))";
        Pattern pstart = Pattern.compile(reg);
        Matcher matcher = pstart.matcher(str);

        int countS = 0;
        int countE = 0;
        int start = 0;
        int end = 0;

        if (matcher.find()) {//если хотябы один

            try {
                while(!matcher.group(1).equals("<" + firstTEG))
                    matcher.find();
            } catch (Exception e) {
                return;
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
                    System.out.println(str.substring(start, end));//.replaceAll("\n|\r",""));
                    String rec = str.substring(start+firstTEG.length()+1,str.length());
                    splitTAG(rec);
                    break;
                }
            }

        }


    }
}
