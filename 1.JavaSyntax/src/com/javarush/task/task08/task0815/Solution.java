package com.javarush.task.task08.task0815;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.put("Ф" + i , "И" + i );
        }

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;
        for (Map.Entry entry : map.entrySet()) {
            count = entry.getValue().equals(name) ? count + 1 : count;
        }
        //return count;
        return Collections.frequency(map.values(), name);
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int count = 0;
        for (Map.Entry entry : map.entrySet()) {
            count = entry.getKey().equals(lastName) ? count + 1 : count;
        }
       // return count;
        return Collections.frequency(map.keySet(), lastName);

    }

    public static void main(String[] args) {

    }
}
