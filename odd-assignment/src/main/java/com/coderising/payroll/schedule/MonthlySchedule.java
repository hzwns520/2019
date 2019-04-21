package com.coderising.payroll.schedule;

import com.coderising.payroll.domain.PaymentSchedule;

import java.time.LocalDate;

/**
 * Created by huangzhengwei on 2019-04-21.
 *
 * @Desciption:
 */
public class MonthlySchedule implements PaymentSchedule {
    @Override
    public boolean isPayDate(LocalDate d) {
        return d.getDayOfMonth() == d.lengthOfMonth();
    }

    @Override
    public LocalDate getPayPeriodStartDate(LocalDate d) {
        return d.minusDays(d.lengthOfMonth() - 1);
    }

    public static void main(String[] args) {
        MonthlySchedule schedule = new MonthlySchedule();
        LocalDate date = LocalDate.of(2019, 4, 30);
        System.out.println(schedule.isPayDate(date));
        System.out.println(schedule.getPayPeriodStartDate(date));
    }
}
