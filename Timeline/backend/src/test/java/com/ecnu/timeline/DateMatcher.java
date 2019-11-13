package com.ecnu.timeline;

import org.mockito.ArgumentMatcher;

import java.util.Date;

/**
 * @author Jiayi Zhu
 * @date 2019-11-13 17:09
 */
public class DateMatcher implements ArgumentMatcher<Date> {
    private Date date;

    public DateMatcher(Date date) {
        this.date = new Date();
        this.date.setTime(date.getTime());
    }

    @Override
    public boolean matches(Date date) {
//        long t1 = this.date.getTime() / 1000;
//        long t2 = date.getTime() / 1000;
//        return t1 == t2;
        return this.date.getTime() == date.getTime();
    }
}
