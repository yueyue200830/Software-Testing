package com.ecnu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.lang.reflect.Field;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PhoneTest {

    @Test
    @DisplayName("Test set time by passing time into it. Will also call setClocksTime")
    void setTime() {
        Clock clockMock = mock(Clock.class);
        Clock[] clocks = new Clock[5];
        for (int i = 0; i < 5; i++) {
            clocks[i] = clockMock;
        }
        Phone phone = new Phone(clocks);

        // test called function in constructor
        verify(clockMock, times(5)).setTime(any());

        Calendar c = Calendar.getInstance();
        phone.setTime(c);

        // test called function in setTime, it should be called 5 times in this function.
        assertEquals(phone.getTime().getTime().getTime(), c.getTime().getTime(), "Set phone time error.");
        verify(clockMock, times(10)).setTime(any());
    }

    @Test
    @DisplayName("Test get time")
    void getTime() throws NoSuchFieldException, IllegalAccessException {
        Clock[] clocks = new Clock[5];
        clocks[0] = new Clock(8, "Beijing");
        clocks[1] = new Clock(0, "London");
        clocks[2] = new Clock(-4, "Moscow");
        clocks[3] = new Clock(10, "Sydney");
        clocks[4] = new Clock(-5, "New York");
        Phone phone = new Phone(clocks);
        Field field = phone.getClass().getDeclaredField("time");
        field.setAccessible(true);
        Calendar c = (Calendar) field.get(phone);
        assertEquals(phone.getTime(), c);
    }
}