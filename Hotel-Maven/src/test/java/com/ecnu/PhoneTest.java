package com.ecnu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

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
}