package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        List<String> argsList = new ArrayList<>();
        if (args.length > 0) {

                switch (args[0]) {
                    case "-c":
                        synchronized (allPeople) {create(args);}
                        break;
                    case "-u":
                        synchronized (allPeople) {update(args);}
                        break;
                    case "-d":
                        synchronized (allPeople) {delete(args);}
                        break;
                    case "-i":
                        synchronized (allPeople) {info(args);}
                        break;
                }

        }
        /*System.out.println("-----------");
        for (Person p: allPeople) {
            System.out.println(p);
        }*/
    }

    public static void create(String[] args) {
        for (int i = 1; i < args.length; i = i + 3) {
            Date date = null;
            try {
                date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i + 2]);
            } catch (ParseException e) {
                System.out.println("неправильный формат строки");
            }
            if (args[i + 1].equals("м"))
                allPeople.add(Person.createMale(args[i], date));
            else
                allPeople.add(Person.createFemale(args[i], date));

            System.out.println(allPeople.size() - 1);
        }

    }

    public static void update(String[] args) {
        for (int i = 1; i < args.length; i = i + 4) {
            Date date = null;
            try {
                date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i + 3]);
            } catch (ParseException e) {
                System.out.println("неправильный формат строки");
            }
            int id = Integer.parseInt(args[i]);
            if (id >= 0 && id < allPeople.size()) {
                Person p = allPeople.get(id);
                p.setName(args[i + 1]);
                p.setSex(args[i + 2].equals("м") ? Sex.MALE : Sex.FEMALE);
                p.setBirthDate(date);
            }
        }
    }

    public static void delete(String[] args) {
        for (int i = 1; i < args.length; i++) {
            allPeople.get(Integer.parseInt(args[i])).delete();
        }


    }

    public static void info(String[] args) {
        for (int i = 1; i < args.length; i++) {
            System.out.println(allPeople.get(Integer.parseInt(args[i])));
        }

    }
}
