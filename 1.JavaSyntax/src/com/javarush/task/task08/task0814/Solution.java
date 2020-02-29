package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        // напишите тут ваш код
        HashSet<Integer> integerHashSet = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            integerHashSet.add(i);
        }
        return integerHashSet;
    }

    public static HashSet<Integer> removeAllNumbersGreaterThan10(HashSet<Integer> set) {
        // напишите тут ваш код
/*        Iterator itr = Map.entrySet().iterator();
        while(itr.hasNext()) {
            Entry entry = itr.next();
            //получить ключ
            K key = entry.getKey();
            //получить значение
            V value = entry.getValue();
        }*/

        Iterator itr = set.iterator();
        while (itr.hasNext()) {
            int i = (int) itr.next();
            if (i > 10) itr.remove();
        }
        return set;
    }

    public static void main(String[] args) {

    }
}
