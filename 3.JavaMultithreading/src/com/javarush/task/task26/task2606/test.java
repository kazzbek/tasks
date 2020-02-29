package com.javarush.task.task26.task2606;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static java.lang.String.format;

public class test {
    public static void main(String[] args) throws ExecutionException, InterruptedException{
        int a= Runtime.getRuntime().availableProcessors() + 1;
        ExecutorService threadPool = Executors.newFixedThreadPool(a);
        Counter counter = new Counter();

        long start = System.nanoTime();

        List<Future<Double>> futures = new ArrayList<>();
        for (int i = 0; i < 400; i++) {
            final int j = i;
            futures.add(
                    CompletableFuture.supplyAsync(
                            () -> counter.count(j),
                            threadPool
                    ));
        }

        double value = 0;
        for (Future<Double> future : futures) {
            value += future.get();
        }

        System.out.println(format("Executed by %d s, value : %f",
                (System.nanoTime() - start) ,
                value));

        threadPool.shutdown();
    }

    }


