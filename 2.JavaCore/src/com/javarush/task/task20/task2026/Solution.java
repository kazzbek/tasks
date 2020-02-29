package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };


      //  clear(0,3,a1);
//        for (int y = 0; y < a1.length; y++) {
//            for (int x = 0; x < a1[0].length; x++) {
//                System.out.print(a1[y][x]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println("=============");
        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        for (int y = 0; y < a.length; y++) {
            for (int x = 0; x < a[0].length; x++) {
                if(a[y][x]==1){
                    clear(x,y,a);
                    count++;
                }
            }
        }
        return count;
    }

    public static void clear(int x, int y, byte[][] a) {
        for (int iY = y-1; iY <= y+1; iY++) {
            for (int iX = x-1; iX <= x+1; iX++) {
                if (iY>=0 && iY<a.length){
                    if(iX>=0 && iX<a[0].length){
                        if(a[iY][iX]==1){
                            a[iY][iX]=0;
                            clear(iX,iY,a);
                        }
                    }
                }
            }
        }
    }
}
