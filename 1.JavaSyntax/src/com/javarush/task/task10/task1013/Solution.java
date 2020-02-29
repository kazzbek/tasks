package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private int age;
        private String name;
        private String lastname;
        private String midlename;
        private String fullname;
        private char sex;

        public Human(int age, String name, String lastname, String midlename, char sex) {
            this.age = age;
            this.name = name;
            this.lastname = lastname;
            this.midlename = midlename;
            this.sex = sex;
        }

        public Human(int age, String fullname, char sex) {
            this.age = age;
            this.fullname = fullname;
            this.sex = sex;
        }

        public Human(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public Human(int age, char sex) {
            this.age = age;
            this.sex = sex;
        }

        public Human(int age, String name, String lastname, char sex) {
            this.age = age;
            this.name = name;
            this.lastname = lastname;
            this.sex = sex;
        }

        public Human(char sex, int age, String name, String lastname) {
            this.age = age;
            this.name = name;
            this.lastname = lastname;
            this.sex = sex;
        }

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, char sex) {
            this.name = name;
            this.sex = sex;
        }

        public Human(String name, String lastname) {
            this.name = name;
            this.lastname = lastname;
        }

        public Human(String name, String lastname, String midlename) {
            this.name = name;
            this.lastname = lastname;
            this.midlename = midlename;
        }
    }
}
