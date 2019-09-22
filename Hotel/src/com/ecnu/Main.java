package com.ecnu;

import java.util.Date;

public class Main {
    private static Phone phone;

    public static void main(String[] args) {
        System.out.println("Hello Hotel");

        phone = new Phone();
        phone.setTime();
        phone.showAllClocksTime();
    }
}
