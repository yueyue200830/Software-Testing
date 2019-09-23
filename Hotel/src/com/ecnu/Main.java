package com.ecnu;

public class Main {
    private static Phone phone;
    private static Clock[] clocks;

    public static void main(String[] args) {
        System.out.println("Hello Hotel!");

        clocks = new Clock[5];
        clocks[0] = new Clock(8, "Beijing");
        clocks[1] = new Clock(0, "London");
        clocks[2] = new Clock(-4, "Moscow");
        clocks[3] = new Clock(10, "Sydney");
        clocks[4] = new Clock(-5, "New York");
        phone = new Phone(clocks);
        phone.setTime();
        phone.showAllClocksTime();

    }
}
