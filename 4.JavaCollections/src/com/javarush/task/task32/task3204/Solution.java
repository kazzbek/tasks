package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bytes = new byte[8];
        List<Integer> num = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            num.add(i);
        }
        Collections.shuffle(num);
        char[] charS = new char[]{
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] chars = new char[]{
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] charN = new char[]{'0','1','2','3','4','5','6','7','8','9'};
        char[] charAll = new char[]{
                '0','1','2','3','4','5','6','7','8','9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        bytes[num.get(0)] = String.valueOf(charN[(int)(Math.random()*1000%charN.length)]).getBytes()[0];
        bytes[num.get(1)] = String.valueOf(chars[(int)(Math.random()*1000%chars.length)]).getBytes()[0];
        bytes[num.get(2)] = String.valueOf(charS[(int)(Math.random()*1000%charS.length)]).getBytes()[0];
        bytes[num.get(3)] = String.valueOf(charAll[(int)(Math.random()*1000%charAll.length)]).getBytes()[0];
        bytes[num.get(4)] = String.valueOf(charAll[(int)(Math.random()*1000%charAll.length)]).getBytes()[0];
        bytes[num.get(5)] = String.valueOf(charAll[(int)(Math.random()*1000%charAll.length)]).getBytes()[0];
        bytes[num.get(6)] = String.valueOf(charAll[(int)(Math.random()*1000%charAll.length)]).getBytes()[0];
        bytes[num.get(7)] = String.valueOf(charAll[(int)(Math.random()*1000%charAll.length)]).getBytes()[0];

        baos.write(bytes);

        return baos;
    }
}