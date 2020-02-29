package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
        this.type = type;
    }

    private boolean canPassengersBeTransferred() {

        if (isDriverAvailable() && fuel > 0)
            return true;
        return false;
    }

    public static Car create(int type, int numberOfPassengers) {
        switch (type) {
            case TRUCK:
                return new Truck(numberOfPassengers);
            case SEDAN:
                return new Sedan(numberOfPassengers);
            case CABRIOLET:
                return new Cabriolet(numberOfPassengers);
        }
        return null;
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0)
            throw new Exception();
        fuel += numberOfLiters;

    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        double consumption;
        if (isSummer(date, SummerStart, SummerEnd)) {
            consumption = getSummerConsumption(length);
        } else {
            consumption = getWinterConsumption(length);
        }
        return consumption;
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (!isDriverAvailable() && !canPassengersBeTransferred() && fuel <= 0)
            return 0;
        return numberOfPassengers;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0)
            fastenPassengersBelts();

        fastenDriverBelt();

    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();

    public boolean isSummer(Date date, Date summerStart, Date summerEnd) {
        if ((date.after(summerStart) && date.before(summerEnd))) {
            return true;
        }
        return false;
    }

    public double getWinterConsumption(int length) {
        double consumption;
        consumption = length * winterFuelConsumption + winterWarmingUp;
        return consumption;
    }

    public double getSummerConsumption(int length) {
        double consumption;
        consumption = length * summerFuelConsumption;
        return consumption;
    }
}