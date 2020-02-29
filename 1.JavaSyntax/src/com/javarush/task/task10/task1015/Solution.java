package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        ArrayList<String>[] arrayOfStringList = new ArrayList[3];
        arrayOfStringList[0] = new ArrayList<>();
        arrayOfStringList[0].add("1");
        arrayOfStringList[0].add("2");
        arrayOfStringList[0].add("3");
        arrayOfStringList[1] = new ArrayList<>();
        arrayOfStringList[1].add("4");
        arrayOfStringList[1].add("5");
        arrayOfStringList[1].add("6");
        arrayOfStringList[2] = new ArrayList<>();
        arrayOfStringList[2].add("7");
        arrayOfStringList[2].add("8");
        arrayOfStringList[2].add("9");

        return arrayOfStringList;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}