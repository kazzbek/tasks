package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {
    static List<String> strings;
    public static List<String> getFileTree(String root) throws IOException {
        File file = new File(root);
        strings = new ArrayList<>();

       // List<String> strings = new ArrayList<>();
        Files.walkFileTree(file.toPath(),new MyFileVisitor(){});
/*
        for (File f: getListFromDir(file)) {
            strings.add(f.getAbsolutePath());
        }
*/
        return strings;

    }

    public static void main(String[] args) throws IOException {
        getFileTree("E:\\testFiles");
    }

    public static List<File> getListFromDir(File dir) {
        List<File> filelist = new ArrayList<>();
        filelist.addAll(Arrays.asList(dir.listFiles()));
        List<File> filelist2 = new ArrayList<>();
        for (File f : filelist) {
            if (f.isDirectory())
                filelist2.addAll(getListFromDir(f));
        }
        filelist.addAll(filelist2);
        for (int i = filelist.size() - 1; i >= 0; i--) {
            if (filelist.get(i).isDirectory())
                filelist.remove(i);
        }
        return filelist;
    }

    static class MyFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path path,
                                         BasicFileAttributes fileAttributes) {
            System.out.println("file name:" + path.toString());
            strings.add(path.toString());
            return FileVisitResult.CONTINUE;
        }
    }
}
