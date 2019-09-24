package com.ecnu;

import java.util.Calendar;

public class Phone {
    private Calendar time;
    private int timeZone;
    private Clock[] clocks;

    // Generate time by current time. Suppose we are always in +8 timezone.
    Phone (Clock[] clocks) {
        this.timeZone = 8;
        this.time = Calendar.getInstance();
        this.clocks = clocks;
        this.setClocksTime();
    }

    // Set time by current time. Suppose we are always in +8 timezone.
    public void setTime() {
        this.time = Calendar.getInstance();
        this.setClocksTime();
    }

    public void setTime(Calendar time) {
        this.time.setTime(time.getTime());
        this.setClocksTime();
    }

    public Calendar getTime() {
        Calendar c = Calendar.getInstance();
        c.setTime(this.time.getTime());
        return c;
    }

    private void setClocksTime() {
        Calendar ZeroZoneTime = Calendar.getInstance();
        ZeroZoneTime.setTime(this.time.getTime());
        ZeroZoneTime.add(Calendar.HOUR, -8);
        for (int i = 0; i < this.clocks.length; i++) {
            this.clocks[i].setTime(ZeroZoneTime);
        }
    }

    public void showAllClocksTime() {
        this.showTime();
        for (int i = 0; i < this.clocks.length; i++) {
            this.clocks[i].showTime();
        }
        System.out.println();
    }

    public void showTime() {
        System.out.print("The phone's time is ");
        System.out.println(this.time.getTime());
    }
}
