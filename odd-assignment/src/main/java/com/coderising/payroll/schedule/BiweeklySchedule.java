package com.coderising.payroll.schedule;

import com.coderising.payroll.domain.PaymentSchedule;
import com.coderising.payroll.util.DateUtil;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by huangzhengwei on 2019-04-21.
 *
 * @Desciption:
 */
public class BiweeklySchedule implements PaymentSchedule {
    LocalDate firstPayableFriday = DateUtil.parseDate("2019-04-19");
    @Override
    public boolean isPayDate(LocalDate d) {
        /**
         * 判断是否为支付
         * @param d
         * @return boolean
         * @throws
         */
        return firstPayableFriday.plusDays(14).isEqual(d);
    }

    @Override
    public LocalDate getPayPeriodStartDate(LocalDate d) {
        return d.minusDays(13);
    }

    public static void main(String[] args) {
        BiweeklySchedule schedule = new BiweeklySchedule();
        LocalDate d = LocalDate.of(2019, 5, 3);
        System.out.println(schedule.isPayDate(d));

        System.out.println(DateUtil.isFriday(d));

        System.out.println(schedule.getPayPeriodStartDate(d));
    }
}
