package com.javarush.task.task25.task2512;

/* 
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        recmethod(e);


    }
    public void recmethod(Throwable e){
        if(e == null)
            return;
        recmethod(e.getCause());
        System.out.println(e);

    }

    public static void main(String[] args) throws Exception{
        new Solution().
        uncaughtException(new Thread(),
                new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));


    }
}
