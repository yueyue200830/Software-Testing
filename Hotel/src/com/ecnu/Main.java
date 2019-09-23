package com.ecnu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Main {
    private static Phone phone;
    private static Clock[] clocks;

    public static void main(String[] args) throws IOException {
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

        operate();
    }

    public static void operate() throws IOException {
        while (true) {
            System.out.println("What do you want to do?");
            System.out.println("1. Set time by yourself.");
            System.out.println("2. Set time by sync automatically.");
            System.out.println("Press -1 to exit.");

            BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
            String input = scanner.readLine();

            if (input.equals("1")) {
                System.out.println("Pressed 1.");
                setTimeByInput();
            } else if (input.equals("2")) {
                System.out.println("Pressed 2.");
                System.out.println("Will sync time automatically.");
                System.out.println("............................");
                phone.setTime();
                System.out.println("All clock's time has been set!");
                phone.showAllClocksTime();
            } else if (input.equals("-1") || input.equals("exit")) {
                System.out.println("Exit");
                System.out.println("Bye!");
                break;
            } else {
                System.out.println("Invalid input. Please try again.");
                System.out.println();
            }
        }
    }

    public static void setTimeByInput() throws IOException {
        System.out.println("Please input the exact time in format: yyyy-MM-dd hh:mm:ss");
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String input = scanner.readLine();

        // Check input
        boolean valid = true;
        if (input.length() != 19 || input.charAt(4) != '-' || input.charAt(7) != '-' || input.charAt(10) != ' ' ||
            input.charAt(13) != ':' || input.charAt(16) != ':') {
            valid = false;
        } else {
            try {
                int year = Integer.parseInt(input.substring(0, 4));
                int month = Integer.parseInt(input.substring(5, 7));
                int day = Integer.parseInt(input.substring(8, 10));
                int hour = Integer.parseInt(input.substring(11, 13));
                int minute = Integer.parseInt(input.substring(14, 16));
                int second = Integer.parseInt(input.substring(17, 19));
                Calendar c = Calendar.getInstance();
                c.set(year, month - 1, day, hour, minute, second);
                phone.setTime(c);
                phone.showAllClocksTime();
            } catch (NumberFormatException e) {
                valid = false;
            }
        }

        if (!valid) {
            System.out.println("Invalid input!");
            System.out.println();
        }
    }
}
