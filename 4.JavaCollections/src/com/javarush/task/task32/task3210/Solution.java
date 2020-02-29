package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException{

        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text1 = args[2];
        byte[] bytes = new byte[text1.length()];
        RandomAccessFile raf = new RandomAccessFile(fileName,"rw");
        raf.seek(number);
        raf.read(bytes,0,bytes.length);
        String text2 = new String(bytes);
        raf.seek(raf.length());
        if(text1.equals(text2)){
            raf.write("true".getBytes());
        }else {
            raf.write("false".getBytes());
        }
        raf.close();
    }
}
