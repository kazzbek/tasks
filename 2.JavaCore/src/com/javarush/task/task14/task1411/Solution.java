package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        while (true){
            key = reader.readLine();
            if (!key.equals("user") && !key.equals("loser") && !key.equals("coder") && !key.equals("proger"))break;
            if(key.equals("user")){
                person = new Person.User();
            } else if (key.equals("loser")){
                person = new Person.Loser();
            } else if (key.equals("coder")){
                person = new Person.Coder();
            } else {person = new Person.Proger();}
            doWork(person);
        }
    }

    public static void doWork(Person person) {
        person.doWork();
    }
}
