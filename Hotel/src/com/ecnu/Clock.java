package com.ecnu;

import java.util.Calendar;

public class Clock {
    private Calendar time;
    private int timeZone;
    private String place;

    Clock (int timeZone, String place) {
        this.timeZone = timeZone;
        this.time = Calendar.getInstance();
        this.place = place;
        this.time.add(Calendar.HOUR, timeZone - 8);
    }

    public void setTime(Calendar time) {
        this.time.clear();
        this.time.setTime(time.getTime());
        this.time.add(Calendar.HOUR, timeZone);
    }

    public Calendar getTime() {
        Calendar c = Calendar.getInstance();
        c.setTime(this.time.getTime());
        return c;
    }

    public void showTime() {
        System.out.print("This is " + this.place + ". ");
        System.out.print("It's time zone is " + this.timeZone + ". ");
        System.out.print("Current time is ");
        System.out.println(this.time.getTime());
    }
}
