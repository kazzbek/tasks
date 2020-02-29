package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

        String str = "Иванов Иван Иванович 31 12 1950";
        str=str.replaceFirst("(\\S+)\\s(\\S+)\\s(\\S+)\\s(.+)","$4");


//        List<String> list = new ArrayList<>();
//        list.addAll(Arrays.asList(arr));
        System.out.println(str);

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String line = fileScanner.nextLine();

            SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
            return new Person(
                    line.replaceFirst("(\\S+)\\s(\\S+)\\s(\\S+)\\s(.+)","$1"),
                    line.replaceFirst("(\\S+)\\s(\\S+)\\s(\\S+)\\s(.+)","$2"),
                    line.replaceFirst("(\\S+)\\s(\\S+)\\s(\\S+)\\s(.+)","$0"),
                    format.parse(line.replaceFirst("(\\S+)\\s(\\S+)\\s(\\S+)\\s(.+)","$4")));
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
