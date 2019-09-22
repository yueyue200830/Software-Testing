package com.ecnu;

import java.util.Date;

public class Phone {
    private Date time;
    private int timeZone;
    private Clock[] clocks;

    // Generate time by current time. Suppose we are always in +8 timezone.
    Phone () {
        this.timeZone = 8;
        this.time = new Date();
        this.clocks = new Clock[5];
        this.clocks[0] = new Clock(8, "Beijing");
        this.clocks[1] = new Clock(0, "London");
        this.clocks[2] = new Clock(-4, "Moscow");
        this.clocks[3] = new Clock(10, "Sydney");
        this.clocks[4] = new Clock(-5, "New York");
        this.setClocksTime();
    }

    Phone (Date time) {
        this.timeZone = 8;
        this.time = time;
        this.clocks = new Clock[5];
        this.clocks[0] = new Clock(8, "Beijing");
        this.clocks[1] = new Clock(0, "London");
        this.clocks[2] = new Clock(-4, "Moscow");
        this.clocks[3] = new Clock(10, "Sydney");
        this.clocks[4] = new Clock(-5, "New York");
        this.setClocksTime();
    }

    // Set time by current time. Suppose we are always in +8 timezone.
    public void setTime() {
        this.time.setTime((new Date()).getTime());
        this.setClocksTime();
    }

    public void setTime(Date time) {
        this.time.setTime(time.getTime());
        this.setClocksTime();
    }

    private void setClocksTime() {
        for (int i = 0; i < this.clocks.length; i++) {

            long ms = this.time.getTime() - timeZone * 1000 * 60 * 60;
            Date d = new Date(ms);
            this.clocks[i].setTime(d);
        }
    }

    public void showAllClocksTime() {
        this.showTime();
        for (int i = 0; i < this.clocks.length; i++) {
            this.clocks[i].showTime();
        }
    }

    public void showTime() {
        System.out.print("The phone's time is ");
        System.out.println(this.timeZone);
    }
}
