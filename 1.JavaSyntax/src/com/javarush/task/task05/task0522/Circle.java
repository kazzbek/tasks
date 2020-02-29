package com.javarush.task.task05.task0522;

/* 
Максимум конструкторов
*/

public class Circle {
    public double x;
    public double y;
    public double radius;

    public Circle() {
        this.radius = 0;
        this.x = 0;
        this.y = 0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Circle(double x, double y) {
        this.x = x;
        this.y = y;
    }
//напишите тут ваш код

    public static void main(String[] args) {

    }
}