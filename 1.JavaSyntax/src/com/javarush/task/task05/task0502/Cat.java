package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код
        double kpd = this.weight*this.strength/1.0/this.age;
        double kpd2 = anotherCat.weight*anotherCat.strength/1.0/anotherCat.age;
        if (kpd>kpd2)
            return true;
        else
            return false;

    }

    public static void main(String[] args) {

    }
}
