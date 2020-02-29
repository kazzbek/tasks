package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] sols=new Solution[2];
        Solution sol1 = new Solution();
        sol1.innerClasses[0]=sol1.new InnerClass();
        sol1.innerClasses[1]=sol1.new InnerClass();
        Solution sol2 = new Solution();
        sol2.innerClasses[0]=sol2.new InnerClass();
        sol2.innerClasses[1]=sol2.new InnerClass();
        sols[0]=sol1;
        sols[1]=sol2;

        return sols;
    }

    public static void main(String[] args) {

    }
}
