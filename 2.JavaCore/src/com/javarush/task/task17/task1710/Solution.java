package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        if (args.length > 0) {
            if (args[0].equals("-c")) {
                Date date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3]);
                if (args[2].equals("м"))
                    allPeople.add(Person.createMale(args[1], date));
                else
                    allPeople.add(Person.createFemale(args[1], date));

                System.out.println(allPeople.size() - 1);
            } else if (args[0].equals("-u")) {
                Date date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[4]);
                int id = Integer.parseInt(args[1]);
                if (id >= 0 && id < allPeople.size()) {
                    Person p = allPeople.get(id);
                    p.setName(args[2]);
                    p.setSex(args[3].equals("м") ? Sex.MALE : Sex.FEMALE);
                    p.setBirthDate(date);
                }

            } else if (args[0].equals("-d")) {
                allPeople.get(Integer.parseInt(args[1])).delete();
            } else if (args[0].equals("-i")) {
                System.out.println(allPeople.get(Integer.parseInt(args[1])));
            }
        }


    }
}
