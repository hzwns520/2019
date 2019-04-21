package com.coderising.payroll.schedule;

import com.coderising.payroll.domain.PaymentSchedule;
import com.coderising.payroll.util.DateUtil;

import java.time.LocalDate;

/**
 * Created by huangzhengwei on 2019-04-21.
 *
 * @Desciption:兼职的发薪
 */
public class WeeklySchedule implements PaymentSchedule {
    @Override
    public boolean isPayDate(LocalDate d) {
        return DateUtil.isFriday(d);
    }

    @Override
    public LocalDate getPayPeriodStartDate(LocalDate d) {
        return d.minusDays(6);
    }
}
