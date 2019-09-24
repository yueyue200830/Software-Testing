package com.ecnu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class ClockTest {
    Clock clock;

    @BeforeEach
    void init() {
        clock = new Clock(0, "London");
    }

    @Test
    @DisplayName("Test set time")
    void setTime() {
        Calendar c = Calendar.getInstance();
        clock.setTime(c);
        assertEquals(clock.getTime().getTime().getTime(), c.getTime().getTime(), "Set clock time error.");
    }

}