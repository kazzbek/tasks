package com.javarush.task.task18.task1828;

/*
Прайсы
*/

import java.io.*;
import java.util.*;

public class Solution {

    private Solution() {
    }


    public static String key = null;
    public static String productName = null;
    public static String price = null;
    public static String quantity = null;
    public static String id = null;


    public static void main(String[] args) throws Exception {
        //для отладки
     /*   args = new String[]{"-u","19847983", "produc","tName3", "5", "5"};
        InputStream setInSteam = new ByteArrayInputStream("E:\\testFiles\\price.txt".getBytes());
        System.setIn(setInSteam);*/
        //конец отладки

        List<Item> itemList = new ArrayList<>();
        String fileName = "";


        if (args.length > 0) {
            key = args[0];


            fileName = readFilename();

            readFile(fileName, itemList);
            getParams(key, args);
            switch (key) {
                case "-c":
                    itemList.add(new Item(productName, price, quantity));
                    break;
                case "-u":
                    int indexToUpdate = getIndexFromListById(itemList, id);
                    itemList.set(indexToUpdate, new Item(id, productName, price, quantity));
                    break;
                case "-d":
                    int indexToDelete = getIndexFromListById(itemList, id);
                    itemList.remove(indexToDelete);
                    break;
            }

            writeListToFile(itemList, fileName);
        }
    }

    private static int getIndexFromListById(List<Item> itemList, String id) {
        int i = 0;
        while (true) {
            if (itemList.get(i).id.equals(id)) break;
            i++;
        }
        return i;
    }


    private static String readFilename() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        return fileName;
    }


    public static void readFile(String fileName, List<Item> itemList) throws IOException {
        FileInputStream inputStream = new FileInputStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8")); //"windows-1251"));

        while (reader.ready()) {
            itemList.add(new Item(reader.readLine()));
        }
        reader.close();
        inputStream.close();
    }

    public static void writeListToFile(List<Item> itemList, String fileName) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(fileName);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
        for (int i = 0; i < itemList.size(); i++) {
            writer.write(itemList.get(i).toString());
            if (i != itemList.size() - 1)
                writer.newLine();

        }
        writer.close();
        outputStream.close();
    }


    public static void getParams(String key, String[] args) {
        switch (key) {
            case "-c":
                //TODO: не учтена возможность того что productName может быть разделен
                // пробелами и из-за этого поменяется количество аргументов
                productName = args[1];
                price = args[2].trim();
                quantity = args[3].trim();
                break;
            case "-u":
                //преобразовал все к стрингу :(
                id = args[1].trim();/*
                String str = String.join(" ", args);
                str = str.substring(str.indexOf(" ")+1);//удаляем ключ
                str = str.substring(str.indexOf(" ")+1);//удаляем id
                quantity = str.substring(str.lastIndexOf(" ")).trim();
                str = str.substring(0,str.lastIndexOf(" "));//удаляем quantity
                price = str.substring(str.lastIndexOf(" ")).trim();
                str = str.substring(0,str.lastIndexOf(" "));//удаляем price
                productName = str;*/
                productName = args[2];
                price = args[3].trim();
                quantity = args[4].trim();


                break;
            case "-d":
                id = args[1].trim();
                break;
        }
    }


}

