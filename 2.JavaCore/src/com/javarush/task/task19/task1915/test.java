package com.javarush.task.task19.task1915;

import java.io.*;
import java.net.URL;

public class test {
    public static void main(String arr[]) throws FileNotFoundException
    {
        PrintStream filePrintStream = new PrintStream(new File("E:\\test.txt"));

       /*Сохраним текущее значение System.out в отдельную переменную, чтобы потом
       можно было переключиться обратно на вывод в консоль*/
        PrintStream console = System.out;

        // Присваиваем System.out новое значение
        System.setOut(filePrintStream);
        System.out.println("Эта строка будет записана в текстовый файл");

        // Возвращаем System.out старое значение
        System.setOut(console);
        System.out.println("А эта строка - в консоль!");
    }
}
