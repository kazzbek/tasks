package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import org.omg.CORBA.portable.InputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {

/*
        ByteArrayInputStream input = new ByteArrayInputStream("E:\\3.txt\nE:\\4.txt\n".getBytes());
        System.setIn(input);*/

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream outputStream = new FileOutputStream(file2);
        byte[] bytefile1 = null;
        if (inputStream.available() > 0) {
            bytefile1 = new byte[inputStream.available()];
            inputStream.read(bytefile1,0,inputStream.available());
        }
        String strfile1 =new String(bytefile1, "UTF-8");
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(strfile1.split(" ")));
        System.out.println(list);

        for (String s: list) {
            s=Math.round(Double.parseDouble(s))+" ";
            outputStream.write(s.getBytes());
        }

        inputStream.close();
        outputStream.close();
    }
}
