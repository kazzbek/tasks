package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String catname = reader.readLine();
        Cat catGFather = new Cat(catname);

        catname = reader.readLine();
        Cat catGMother = new Cat(catname);

        catname = reader.readLine();
        Cat catFather = new Cat(catname,null,catGFather);

        catname = reader.readLine();
        Cat catMother = new Cat(catname, catGMother, null);

        catname = reader.readLine();
        Cat catSon = new Cat(catname, catMother, catFather);

        catname = reader.readLine();
        Cat catDaughter = new Cat(catname, catMother, catFather);



        System.out.println(catGFather);
        System.out.println(catGMother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat parentF;
        private Cat parentM;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat parentF, Cat parentM) {
            this.name = name;
            this.parentF = parentF;
            this.parentM = parentM;
        }

        @Override
        public String toString() {
            String s = "The cat's name is " + name;
            if (parentF == null)
                s += ", no mother";
            else
                s += ", mother is " + parentF.name;
            if (parentM == null)
                s += ", no father";
            else
                s += ", father is " + parentM.name;
            return s;
        }
    }

}
