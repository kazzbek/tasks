package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    //напишите тут ваш код
    String name;
    int age;
    int weight;
    String address;
    String color;

    public Cat(String name) {
        this.name = name;
        this.age=2;
        this.weight=5;
        this.color="цветной";
        this.address=null;

    }

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color="цветной";
        this.address=null;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight=5;
        this.color="цветной";
        this.address=null;
    }

    public Cat(int weight, String color) {
        this.name=null;
        this.weight = weight;
        this.color = color;
        this.address=null;
        this.age=2;
    }

    public Cat(int weight, String color, String address) {
        this.age=2;
        this.name=null;
        this.weight = weight;
        this.address = address;
        this.color = color;
    }

    public static void main(String[] args) {

    }
}
