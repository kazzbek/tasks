package com.javarush.task.task27.task2707;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/*
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        //do something here
        ObjLock objLock1 = new ObjLock(o1, 100);
        objLock1.start();
        PrintStream sout = System.out;
        System.setOut(new PrintStream(new ByteArrayOutputStream()));

        Thread t = new Thread(() -> solution.someMethodWithSynchronizedBlocks(o1, o2));
        t.start();


        ObjLock objLock2 = new ObjLock(o2, 20);
        objLock2.start();

        Thread.sleep(50);
        boolean ret = !objLock2.isAlive();
        Thread.sleep(50);
        System.setOut(sout);
        return ret;
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }

    public static class ObjLock extends Thread {
        Object lock;
        int time;

        public ObjLock(Object lock, int time) {
            this.lock = lock;
            this.time = time;
        }

        @Override
        public void run() {
            synchronized (lock) {
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
