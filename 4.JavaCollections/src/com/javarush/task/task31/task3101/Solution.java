package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[]{"E:\\testFiles", "E:\\result.txt"};
        File dir = new File(args[0]);
        File result = new File(args[1]);
        File newName = new File(result.getParent() + "/allFilesContent.txt");

        List<File> filelist = getListFromDir(dir);
        SortAndCheckList(filelist);
        FileUtils.renameFile(result, newName);

        WritelistContentToFile(filelist,newName);

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

    public static void SortAndCheckList(List<File> filelist) {
        filelist.sort(new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for (int i = filelist.size() - 1; i >= 0; i--) {
            if (filelist.get(i).length() > 50)
                filelist.remove(i);
        }
    }

    public static void WritelistContentToFile(List<File> fileList, File wfile) throws IOException {

        try (FileOutputStream fileOutputStream = new FileOutputStream(wfile)) {

            for (File file : fileList) {
                FileInputStream fileInputStream = new FileInputStream(file);
                while (fileInputStream.available() > 0) {
                    fileOutputStream.write(fileInputStream.read());
                }
                fileOutputStream.write(System.lineSeparator().getBytes());
                fileOutputStream.flush();

                fileInputStream.close();
            }
        }

    }
}
