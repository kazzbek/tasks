package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        //для отладки
    /*    args = new String[]{"-c", "productName", "5", "5"};
        InputStream setInSteam = new ByteArrayInputStream("D:\\testfiles\\price.txt".getBytes());
        System.setIn(setInSteam);*/
        //конец отладки

        List<Item> itemList = new ArrayList<>();
        String fileName = "";

        String key = null;
        String productName = null;
        double price = 0;
        int quantity = 0;

        if(args.length>0){
            key = args[0];
            productName = args[1];
            price = Double.parseDouble(args[2].trim());
            quantity = Integer.parseInt(args[3].trim());

            fileName = readFilename();

            readFile(fileName, itemList);

            switch (key) {
                case "-c":
                    itemList.add(new Item(productName, price, quantity));
                    writeListToFile(itemList, fileName);
                    break;
            }
        }
    }

    private static String readFilename() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        return fileName;
    }

    public static void readFile(String fileName, List<Item> itemList) throws IOException {
        FileInputStream inputStream = new FileInputStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));//"windows-1251"));

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


}

