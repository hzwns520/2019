package com.coderising.payroll.transaction;

import com.coderising.payroll.classification.HourlyClassification;
import com.coderising.payroll.domain.PaymentCalssification;
import com.coderising.payroll.domain.PaymentSchedule;
import com.coderising.payroll.schedule.WeeklySchedule;

/**
 * Created by huangzhengwei on 2019-04-21.
 *
 * @Desciption:
 */
public class AddHourlyEmployeeTransaction extends AddEmployeeTransaction {

    private double rate;

    public AddHourlyEmployeeTransaction(String name, String address, double hourlyDate) {
        super(name, address);
        this.rate = hourlyDate;
    }

    @Override
    public PaymentCalssification getClassification() {
        return new HourlyClassification(rate);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new WeeklySchedule();
    }
}
