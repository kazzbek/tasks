package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
//        Human gF1 = new Human("дед1",true,80, new ArrayList<Human>(new Human()))
        Human c1 = new Human("реб1",true,15);
        Human c2 = new Human("реб2",true,15);
        Human c3 = new Human("реб3",true,15);
        Human f = new Human("Отец",true,41, c1,c2,c3);
        Human m = new Human("Мать",false,41, c1,c2,c3);
        Human gf1 = new Human("Дед1",true,81, f);
        Human gm1 = new Human("Бабка1",false,81, f);
        Human gf2 = new Human("Дед2",true,81, m);
        Human gm2 = new Human("Бабка2",false,81, m);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(f);
        System.out.println(m);
        System.out.println(gf1);
        System.out.println(gm1);
        System.out.println(gf2);
        System.out.println(gm2);
    }


    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age, Human ... humans) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            Collections.addAll(this.children,humans);
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
