package com.javarush.task.task26.task2606;

public class Counter {
    public Double count(double a) {
        for (int i = 0; i < 1000000; i++) {
            a = a + Math.tan(a);
        }

        return a;
    }
}
