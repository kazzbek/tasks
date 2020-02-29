package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
//    static {
//        properties.put("1","1");
//        properties.put("2","2");
//    }

    public void fillInPropertiesMap() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream inputStream = new FileInputStream(reader.readLine());
        load(inputStream);
        inputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties p = new Properties();
        p.putAll(properties);
        p.store(outputStream,null);
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties p = new Properties();
        p.load(inputStream);
        for (String name : p.stringPropertyNames()) {
            properties.put(name, p.getProperty(name));
        }
    }

    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
//        FileOutputStream stream = new FileOutputStream("E:\\1.txt");
//        s.save(stream);
        s.fillInPropertiesMap();
    }
}
