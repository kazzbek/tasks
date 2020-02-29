package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 20;
    }

    @Override
    String getDescription() {
        String s=String.format(
                "%s Моя страна - %s. Я несу %d яиц в месяц.",
                super.getDescription(),
                Country.BELARUS,
                this.getCountOfEggsPerMonth());
        return s;
    }
}