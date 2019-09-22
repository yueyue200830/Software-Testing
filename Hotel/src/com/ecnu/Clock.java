package com.ecnu;

import java.util.Date;

public class Clock {
    private Date time;
    private int timeZone;
    private String place;

    Clock (int timeZone, String place) {
        this.time = new Date();
        this.timeZone = timeZone;
        this.place = place;
    }

    Clock (int timeZone, String place, Date currentTime) {
        this.timeZone = timeZone;
        this.time = new Date(currentTime.getTime() + timeZone * 1000 * 60 * 60);
        this.place = place;
    }

    public void setTime(Date currentTime) {
        this.time.setTime(currentTime.getTime() + timeZone * 1000 * 60 * 60);
    }

    public void showTime() {
        System.out.print("This is " + this.place + ". ");
        System.out.print("It's time zone is " + this.timeZone + ". ");
        System.out.print("Current time is ");
        System.out.println(this.time);
    }
}
