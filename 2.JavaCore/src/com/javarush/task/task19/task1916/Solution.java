package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
   /*     InputStream SysIn = new ByteArrayInputStream("E:\\testFiles\\file1.txt\nE:\\testFiles\\file2.txt\n".getBytes());
        System.setIn(SysIn);*/

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        FileReader fileReader1 = new FileReader(file1);
        FileReader fileReader2 = new FileReader(file2);
        BufferedReader brf1 = new BufferedReader(fileReader1);
        BufferedReader brf2 = new BufferedReader(fileReader2);

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        while (brf1.ready()) {
            list1.add(brf1.readLine());
        }
        while (brf2.ready()) {
            list2.add(brf2.readLine());
        }
        brf1.close();
        brf2.close();

        int i1 = 0;
        int i2 = 0;
        while (i1 < list1.size() && i2 < list2.size()) {
            if (list1.get(i1).equals(list2.get(i2))) {//SAME
                lines.add(new LineItem(Type.SAME, list1.get(i1)));
                i1++;
                i2++;
            } else {//REMOVED OR ADDED
                if (i1 + 1 < list1.size() && list1.get(i1 + 1).equals(list2.get(i2))) {//REMOVED
                    lines.add(new LineItem(Type.REMOVED, list1.get(i1++)));
                } else if (i2 + 1 < list2.size() && list1.get(i1).equals(list2.get(i2 + 1))) {//AADDED
                    lines.add(new LineItem(Type.ADDED, list2.get(i2++)));
                }
            }

        }

        if (i1 < list1.size()) {//есть еще одна удаленная строка
            lines.add(new LineItem(Type.REMOVED, list1.get(i1)));
        }
        if (i2 < list2.size()) {//есть еще одна добавленная строка
            lines.add(new LineItem(Type.ADDED, list2.get(i2)));
        }
/*
        for (LineItem item : lines) {
            System.out.printf("%s %s\n", item.type, item.line);
        }*/
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
