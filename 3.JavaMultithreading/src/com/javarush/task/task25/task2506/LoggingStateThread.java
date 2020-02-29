package com.javarush.task.task25.task2506;

import java.util.ArrayList;
import java.util.List;

public class LoggingStateThread extends Thread{
    List<State> states = new ArrayList<>();
    Thread t;
    @Override
    public void run() {
        State s = t.getState();
        System.out.println(s);
        while (true){
            if(t.getState()!=s){
                System.out.println(t.getState());
                s=t.getState();
            }
            if(s==State.TERMINATED)
                break;
        }
    }

    public LoggingStateThread(Thread thread) {
        t = thread;
        setDaemon(true);
    }
}
