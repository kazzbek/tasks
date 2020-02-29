package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) {

        List<String> files = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            files.add(args[i]);
        }
        Collections.sort(files);

        Vector<FileInputStream> vfiles;
        vfiles = new Vector<>(args.length - 1);

        try {
            for (String s : files) {
                vfiles.addElement(new FileInputStream(s));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден");
        }

        SequenceInputStream sis;

        sis = new SequenceInputStream(vfiles.elements());

        try (ZipInputStream zis = new ZipInputStream(sis)) {

            try (FileOutputStream fileOutputStream = new FileOutputStream(new File(args[0]))) {
                while (zis.getNextEntry() != null) {
                    int count;
                    byte[] buffer = new byte[1024];
                    while ((count = zis.read(buffer)) != -1)
                        fileOutputStream.write(buffer, 0, count);
                 /*   int b = zis.read();
                    while (b != -1) ;
                    {
                        fileOutputStream.write(b);
                        b = zis.read();
                    }*/
                }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
