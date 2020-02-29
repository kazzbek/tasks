package com.javarush.task.task14.task1420;

public class NOD {
    public static int getNOD(int a, int b) {
        int nod = 1;
        int c = a > b ? b : a;
        while (c > 0) {
            if (a % c == 0 && b % c == 0) {
                nod = c;
                break;
            }
            c--;
        }
        return nod;
    }
}
