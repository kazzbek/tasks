package com.javarush.task.task08.task0802;

/* 
HashMap из 10 пар
*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        HashMap<String, String> set = new HashMap<>();
        set.put("арбуз","ягода");
        set.put("банан","трава");
        set.put("вишня","ягода");
        set.put("груша","фрукт");
        set.put("дыня","овощ");
        set.put("ежевика","куст");
        set.put("жень-шень","корень");
        set.put("земляника","ягода");
        set.put("ирис","цветок");
        set.put("картофель","клубень");

        Iterator<Map.Entry<String, String>> iterator = set.entrySet().iterator();

        while (iterator.hasNext())
        {
            //получение «пары» элементов
            Map.Entry<String, String> pair = iterator.next();
            String key = pair.getKey();            //ключ
            String value = pair.getValue();        //значение
            System.out.println(key + " - " + value);
        }
    }
}
