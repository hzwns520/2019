package com.coderising.payroll.classification;

import com.coderising.payroll.domain.Paycheck;
import com.coderising.payroll.domain.PaymentCalssification;

/**
 * Created by huangzhengwei on 2019-04-21.
 *
 * @Desciption:
 */
public class SalariedClassification implements PaymentCalssification {

    private double salary;

    public SalariedClassification(double salary) {
        this.salary = salary;
    }

    @Override
    public double calculatePay(Paycheck pc) {
        return salary;
    }
}
