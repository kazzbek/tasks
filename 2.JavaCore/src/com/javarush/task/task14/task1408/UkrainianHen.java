package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 40;
    }

    @Override
    String getDescription() {
        String s=String.format(
                "%s Моя страна - %s. Я несу %d яиц в месяц.",
                super.getDescription(),
                Country.UKRAINE,
                this.getCountOfEggsPerMonth());
        return s;
    }
}
