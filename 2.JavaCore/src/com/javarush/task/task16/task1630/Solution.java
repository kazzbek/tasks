package com.javarush.task.task16.task1630;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //add your code here - добавьте код тут
    static {
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //add your code here - добавьте код тут

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());

    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String FileName;
        private String FileContent = "";

        @Override
        public void setFileName(String fullFileName) {
            this.FileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            return FileContent;
        }

        @Override
        public void run() {
            BufferedReader readerFile = null;
            try {
                readerFile = new BufferedReader(new FileReader(FileName));
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден");
            }
            String line;
            String lines = "";
            try {
                while ((line = readerFile.readLine()) != null) {
                    lines += " " + line;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            FileContent = lines.trim();

        }
    }

    //add your code here - добавьте код тут
}
