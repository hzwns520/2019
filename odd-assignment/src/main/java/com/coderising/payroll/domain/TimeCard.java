package com.coderising.payroll.domain;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by huangzhengwei on 2019-04-21.
 *
 * @Desciption:
 */
public class TimeCard {

    private LocalDate date;

    private int hours;

    public TimeCard(LocalDate date, int hours) {
        this.date = date;
        this.hours = hours;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }
}
