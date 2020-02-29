package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        HashMap<String, Integer> map = new HashMap<>();

        while(true){
            s = reader.readLine();
            String name;
            int id;
            if (!s.equals("")){
                id = Integer.parseInt(s);
                s = reader.readLine();
                if (!s.equals("")){
                    name = s;
                }else {
                    map.put("",id); break;
                }
            }else break;


             map.put(name,id);
        }

        for (Map.Entry e: map.entrySet()) {
            System.out.println(e.getValue() + " " + e.getKey());
        }

    }
}
