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

public class Solution2 {
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

        //firstTEG = m.group(1);
        firstTEG = args[0];
        splitTAG(stringFile);



    }

    public static void splitTAG(String str) {
        Pattern pstart = Pattern.compile("<" + firstTEG);
        Pattern pend = Pattern.compile("</" + firstTEG + ">");
        Matcher mStart = pstart.matcher(str);
        Matcher mEnd = pend.matcher(str);
        int tempstart = 0;
        int end = 0;
        boolean noWasBreak = true;
        if (mStart.find()) {
            mEnd.find();
            // System.out.println();
            int start = mStart.start();
            end = mEnd.end();

            while (mStart.find()) {
                tempstart = mStart.start();
                noWasBreak = true;
                while (mStart.start() < mEnd.end()) {
                    if (mStart.find())
                        mEnd.find();
                    else {
                        noWasBreak = false;
                        break;
                    }
                    tempstart = mStart.start();
                    end = mEnd.end();
                }
                if (tempstart < end)
                    mEnd.find();
                end = mEnd.end();
                mEnd.find();
                String out = str.substring(start, end);
                System.out.println(out);
                splitTAG(out.substring(1, out.length() - 1));
                if (tempstart < end)
                    break;
                start = mStart.start();
                end = mEnd.end();
            }
            if (noWasBreak) {
                String out = str.substring(start, end);
                System.out.println(out);
                splitTAG(out.substring(1, out.length() - 1));
            }
        }
    }
}
