package com.javarush.task.test;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;


public class test {
    public static void main(String[] args) throws IOException
    {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 4;

        StringWriter writer = new StringWriter();

        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(writer, cat);

        String result = writer.toString();
        System.out.println(result);
    }
}
