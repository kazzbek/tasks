package com.javarush.task.task28.task2805;

public class MyThread extends Thread {
    static int prior = 0;

    public MyThread() {
        this.setPriority(getPrior(null));
    }

    public MyThread(Runnable target) {
        super(target);
        this.setPriority(getPrior(null));
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        this.setPriority(getPrior(group));
    }

    public MyThread(String name) {
        super(name);
        this.setPriority(getPrior(null));
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        this.setPriority(getPrior(group));
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        this.setPriority(getPrior(null));
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        this.setPriority(getPrior(group));
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        this.setPriority(getPrior(group));
    }

    public static int getPrior(ThreadGroup group) {
        prior++;
        if (prior > 10)
            prior = 1;
        if (group == null)
            return prior;
        else
            return prior > group.getMaxPriority() ? group.getMaxPriority() : prior;
    }
}
