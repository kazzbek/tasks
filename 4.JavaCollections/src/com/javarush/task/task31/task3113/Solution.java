package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution  {
    public static int countOfFolders = -1;
    public static int countOfFiles = 0;
    public static long totalBytes = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String pathStr = reader.readLine();
        reader.close();
        Path pth = Paths.get(pathStr);
        if(!Files.isDirectory(pth)){
            System.out.println(pth.toAbsolutePath().toString()+" - не папка");
            return;
        }

        Files.walkFileTree(pth,new MyFileVisitor(){});

        System.out.println("Всего папок - " + countOfFolders);
        System.out.println("Всего файлов - " + countOfFiles);
        System.out.println("Общий размер - " + totalBytes);
    }

    static class MyFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path path,
                                         BasicFileAttributes fileAttributes) {
            countOfFiles++;
            totalBytes+=fileAttributes.size();
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            countOfFolders++;
            return FileVisitResult.CONTINUE;
        }
    }

}
