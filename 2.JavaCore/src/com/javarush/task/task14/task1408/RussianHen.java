package com.javarush.task.task14.task1408;

public class RussianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 50;
    }

    @Override
    String getDescription() {
        String s=String.format(
                "%s Моя страна - %s. Я несу %d яиц в месяц.",
                super.getDescription(),
                Country.RUSSIA,
                this.getCountOfEggsPerMonth());
        return s;
    }
}
