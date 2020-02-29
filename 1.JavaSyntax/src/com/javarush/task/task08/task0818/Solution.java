package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> set = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            set.put("Фамилия" + i, (i * 100));
        }
        return set;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        set.removeIf(x -> x.getValue() < 500);
    }

    public static void main(String[] args) {

    }
}