package com.javarush.task.task16.task1628;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public static volatile AtomicInteger readStringCount = new AtomicInteger(0);
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        //read count of strings
        int count = Integer.parseInt(reader.readLine());

        //init threads
        ReaderThread consolReader1 = new ReaderThread();
        ReaderThread consolReader2 = new ReaderThread();
        ReaderThread consolReader3 = new ReaderThread();

        consolReader1.start();
        consolReader2.start();
        consolReader3.start();

        while (count > readStringCount.get()) {

        }

        consolReader1.interrupt();
        consolReader2.interrupt();
        consolReader3.interrupt();
        System.out.println("#1:" + consolReader1);
        System.out.println("#2:" + consolReader2);
        System.out.println("#3:" + consolReader3);

        reader.close();
    }

    public static class ReaderThread extends Thread {
        private List<String> result = new ArrayList<String>();

        public void run() {
            //add your code here - добавьте код тут

            while (!isInterrupted()) {
                // В блок synchronized нити входят по очереди
                synchronized (reader) {
                    // Сразу проверяем а не прерван ли уже поток и если да - прерываем цикл.
                    if (isInterrupted()) {
                       // System.out.println("Прервали" + Thread.currentThread().getName());
                        return;
                    }
                    try {
                        //Thread.sleep(100);

                        // Только если в буфере есть данные.
                        if (reader.ready()) {
                            result.add(reader.readLine());
                            readStringCount.incrementAndGet();
                      //  System.out.println("Считали и записали" + Thread.currentThread().getName());

                        }
                    } catch (Exception e) {
                       // e.printStackTrace();
                    }
                }
            }
        }

        @Override
        public String toString() {
            return result.toString();
        }
    }
}
