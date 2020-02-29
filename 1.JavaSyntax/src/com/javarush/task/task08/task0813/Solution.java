package com.javarush.task.task08.task0813;

import java.util.Set;
import java.util.HashSet;

/* 
20 слов на букву «Л»
*/

public class Solution {
    public static Set<String> createSet() {
        //напишите тут ваш код
        Set<String> stringSet = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            stringSet.add("Л"+i);
        }
        return stringSet;
    }

    public static void main(String[] args) {

    }
}
