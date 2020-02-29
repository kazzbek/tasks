package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        reset();
    }

    public static CanFly result;

    public static void reset() {
        //add your code here - добавьте код тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String type = null;
        try {
            type = reader.readLine();
        } catch (IOException e) {
            System.out.println("Ошибка");
        }
        if(type.equals("helicopter"))
            result = new Helicopter();
        else if (type.equals("plane")){
            try {
                result = new Plane(Integer.parseInt(reader.readLine()));
            } catch (IOException e) {
                System.out.println("Ошибка");
            }
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
