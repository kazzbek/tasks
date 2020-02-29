package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader(reader.readLine());
        reader.close();
        BufferedReader br = new BufferedReader(fr);
        while (br.ready()){
            char[] chars =br.readLine().toCharArray();
            for (int i = chars.length-1; i >=0 ; i--) {
                System.out.print(chars[i]);
            }
            if(br.ready()) System.out.println();
        }
        fr.close();
        br.close();

    }
}
