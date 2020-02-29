package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        ArrayList<int[]> list = new ArrayList<>();
        int[] arr5 = {1,2,3,4,5};
        int[] arr2 = {1,2};
        int[] arr4 = {1,2,3,4};
        int[] arr7 = {1,2,3,4,5,6,7};
        int[] arr0 = {};
        list.add(arr5);
        list.add(arr2);
        list.add(arr4);
        list.add(arr7);
        list.add(arr0);

        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
