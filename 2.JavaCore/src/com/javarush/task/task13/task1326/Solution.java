package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        List<Character> characterList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;

        try {
            fileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.getMessage();
        }

        try(FileInputStream fin=new FileInputStream(fileName))
        {
            byte[] buffer = new byte[fin.available()];
                // считаем файл в буфер
            fin.read(buffer, 0, fin.available());
            for (byte b: buffer) {
                characterList.add((char)b);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        String s ="";
        for (Character a: characterList) {
            s+=a;
        }

        String[] subStr;
        subStr = s.split(System.lineSeparator());

        for (String ss: subStr) {
            if (Integer.parseInt(ss)%2==0){
                list.add(Integer.parseInt(ss));
            }
        }
        Collections.sort(list);
        for (Integer i: list) {
            System.out.println(i);

        }



    }
}
