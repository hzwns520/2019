package com.coderising.payroll.domain;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by huangzhengwei on 2019-04-21.
 *
 * @Desciption:
 */
public interface PaymentSchedule {
    boolean isPayDate(LocalDate d);

    LocalDate getPayPeriodStartDate(LocalDate d);
}
