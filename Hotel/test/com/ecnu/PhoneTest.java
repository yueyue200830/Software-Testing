package com.ecnu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {
    Phone phone;
    Clock[] clocks;

    @BeforeEach
    void init() {
        clocks = new Clock[5];
        clocks[0] = new Clock(8, "Beijing");
        clocks[1] = new Clock(0, "London");
        clocks[2] = new Clock(-4, "Moscow");
        clocks[3] = new Clock(10, "Sydney");
        clocks[4] = new Clock(-5, "New York");
        phone = new Phone(clocks);
    }

    @Test
    @DisplayName("Test set time by passing time into it")
    void setTime() {
        Calendar c = Calendar.getInstance();
        phone.setTime(c);
        assertEquals(phone.getTime().getTime().getTime(), c.getTime().getTime(), "Set phone time error.");
    }

    @Test
    @DisplayName("Test set clock's time")
    void setClocksTime() {
        Calendar cPhone = phone.getTime();

    }
}