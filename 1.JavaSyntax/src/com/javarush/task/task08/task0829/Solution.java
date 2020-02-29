package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // List of addresses
        HashMap<String,String> familyadress = new HashMap<>();

        while (true) {
            //System.out.println("Введите город: ");
            String city = reader.readLine();
            if (city.isEmpty()) break;
            //System.out.println("Введите фамилию: ");
            String family= reader.readLine();
            if (family.isEmpty()) break;
            familyadress.put(city,family);

        }

        // Read the city
        String city = reader.readLine();

        System.out.println(familyadress.get(city));

//        if (0 <= houseNumber && houseNumber < addresses.size()) {
//            String familyName = addresses.get(houseNumber);
//            System.out.println(familyName);
//        }
    }
}
