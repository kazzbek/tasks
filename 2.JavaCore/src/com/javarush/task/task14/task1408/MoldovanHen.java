package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 30;
    }

    @Override
    String getDescription() {
        String s=String.format(
                "%s Моя страна - %s. Я несу %d яиц в месяц.",
                super.getDescription(),
                Country.MOLDOVA,
                this.getCountOfEggsPerMonth());
        return s;
    }
}
