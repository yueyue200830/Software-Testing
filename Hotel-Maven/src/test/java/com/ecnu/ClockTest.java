package com.ecnu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class ClockTest {
    Clock clock;

    @BeforeEach
    void setUp() {
        clock = new Clock(0, "London");
    }

    @Test
    @DisplayName("Test set time")
    void setTime() {
        Calendar c = Calendar.getInstance();
        clock.setTime(c);
        assertEquals(clock.getTime().getTime().getTime(), c.getTime().getTime(), "Set clock time error.");
    }

    @Test
    @DisplayName("Test get time")
    void getTime() throws NoSuchFieldException, IllegalAccessException {
        Field field = clock.getClass().getDeclaredField("time");
        field.setAccessible(true);
        Calendar c = (Calendar) field.get(clock);
        assertEquals(clock.getTime(), c);
    }
}