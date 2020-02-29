package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    public static  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static String file1;
    public static String file2;

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        readFilePaths();
        readFile1();
        readFile2();
        //allLines = Files.readAllLines(Paths.get(reader.readLine()));

        try {
            s.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }

        //System.out.println(allLines);


    }
    public static void readFilePaths(){
        try {
            file1 = reader.readLine();
            file2 = reader.readLine();
        } catch (IOException e) {
            System.out.println("Ошибка");
        }
    }

    public static void readFile1(){
        try{
            FileInputStream fstream = new FileInputStream(file1);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null){
                allLines.add(strLine);
            }
            br.close();
            fstream.close();
        }catch (IOException e){
            System.out.println("Ошибка");
        }

    }

    public static void readFile2(){
        try{
            FileInputStream fstream = new FileInputStream(file2);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null){
                forRemoveLines.add(strLine);
            }
            br.close();
            fstream.close();
        }catch (IOException e){
            System.out.println("Ошибка");
        }
    }

    public void joinData() throws CorruptedDataException {
        if(allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }


}
