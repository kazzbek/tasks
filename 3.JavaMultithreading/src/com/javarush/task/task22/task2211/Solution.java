package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        writeUtf8FromWin1251(getBuffer(args[0]), args[1]);
    }

    private static void writeUtf8FromWin1251 (byte[] buff, String file) throws IOException {
        FileOutputStream fs = new FileOutputStream(file);
        fs.write(win1251ToUtf8(buff));
        fs.close();
    }
    public static byte[] win1251ToUtf8 (byte[] buff){
        String s= new String(buff, Charset.forName("windows-1251"));
        return s.getBytes(Charset.forName("UTF-8"));
    }

    private static byte[] getBuffer(String file) throws IOException {
        InputStream is = new FileInputStream(file);
        byte[] buffer = null;
        if (is.available() > 0) {
            buffer = new byte[is.available()];
            is.read(buffer);
        }
        is.close();
        return buffer;
    }
}
