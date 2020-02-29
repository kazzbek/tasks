package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> wordsList = new ArrayList<>();
        for (int y = 0; y < crossword.length; y++) {
            for (int x = 0; x < crossword[0].length; x++) {
                for (String s : words) {
                    wordsList.addAll(chekWord(x,y,crossword,s));
                }
            }
        }
      //  System.out.println(wordsList);
        return wordsList;

    }

    public static List<Word> chekWord(int x, int y, int[][] crossword, String word) {
//        1   2   3
//        8   0   4  направления проверки
//        7   6   5
        List<Word> words = new ArrayList<>();
        int len = word.length();

        if(len==1){
            String s = ""+(char)crossword[y][x];
            if (s.equals(word))
                words.add(new Word(word,x,y,x,y));
            return words;
        }

        //1
        String string="";
        int ex=x,ey=y;
        for (int i = 0; i < len; i++) {
            try {string+=(char)crossword[ey][ex];} catch (Exception e) {}
            ex--;
            ey--;
        }
        if (string.equals(word))words.add(new Word(word,x,y,ex+1,ey+1));

        //2
        string="";
        ex=x;ey=y;
        for (int i = 0; i < len; i++) {
            try {string+=(char)crossword[ey][ex];} catch (Exception e) {}
            ey--;
        }
        if (string.equals(word))words.add(new Word(word,x,y,ex,ey+1));
        //3
        string="";
        ex=x;ey=y;
        for (int i = 0; i < len; i++) {
            try {string+=(char)crossword[ey][ex];} catch (Exception e) {}
            ey--;
            ex++;
        }
        if (string.equals(word))words.add(new Word(word,x,y,ex-1,ey+1));
        //4
        string="";
        ex=x;ey=y;
        for (int i = 0; i < len; i++) {
            try {string+=(char)crossword[ey][ex];} catch (Exception e) {}
            ex++;
        }
        if (string.equals(word))words.add(new Word(word,x,y,ex-1,ey));
        //5
        string="";
        ex=x;ey=y;
        for (int i = 0; i < len; i++) {
            try {string+=(char)crossword[ey][ex];} catch (Exception e) {}
            ex++;
            ey++;
        }
        if (string.equals(word))words.add(new Word(word,x,y,ex-1,ey-1));
        //6
        string="";
        ex=x;ey=y;
        for (int i = 0; i < len; i++) {
            try {string+=(char)crossword[ey][ex];} catch (Exception e) {}
            ey++;
        }
        if (string.equals(word))words.add(new Word(word,x,y,ex,ey-1));
        //7
        string="";
        ex=x;ey=y;
        for (int i = 0; i < len; i++) {
            try {string+=(char)crossword[ey][ex];} catch (Exception e) {}
            ey++;
            ex--;
        }
        if (string.equals(word))words.add(new Word(word,x,y,ex+1,ey-1));
        //8
        string="";
        ex=x;ey=y;
        for (int i = 0; i < len; i++) {
            try {string+=(char)crossword[ey][ex];} catch (Exception e) {}
            ex--;
        }
        if (string.equals(word))words.add(new Word(word,x,y,ex+1,ey));

        return words;
    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public Word(String text, int startX, int startY, int endX, int endY) {
            this.text = text;
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
