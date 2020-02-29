package com.javarush.task.task21.task2113;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses = new ArrayList<>();
    static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public Hippodrome() {
    }

    public static void main(String[] args) {
        game = new Hippodrome();
        game.getHorses().add(new Horse("лошадь1",3,0));
        game.getHorses().add(new Horse("лошадь2",3,0));
        game.getHorses().add(new Horse("лошадь3",3,0));
        game.run();

        game.printWinner();
    }
    public void run(){
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            try {Thread.sleep(200);} catch (InterruptedException e) {}
        }

    }
    public void move(){
        for (Horse h: getHorses()) {
            h.move();
        }

    }
    public void print(){
        for (Horse h: getHorses()) {
            h.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    public Horse getWinner(){
        Horse h = null;
        double max = 0;
        for (Horse horse: horses) {
            if(max<horse.getDistance()){
                max =  horse.getDistance();
                h = horse;
            }

        }
        return h;
    }
    public void printWinner(){
        System.out.printf("Winner is %s!%n",getWinner().getName());
    }
}
