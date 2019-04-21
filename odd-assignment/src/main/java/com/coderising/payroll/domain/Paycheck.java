package com.coderising.payroll.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

/**
 * Created by huangzhengwei on 2019-04-21.
 *
 * @Desciption:
 */
public class Paycheck {

    private LocalDate payPeriodStart;

    private LocalDate payPeriodEnd;

    private double grossPay;

    private double payNet;

    private double deductions;

    private Map<String, String> itesFields;

    public Paycheck(LocalDate payPeriodStart, LocalDate payPeriodEnd) {
        this.payPeriodStart = payPeriodStart;
        this.payPeriodEnd = payPeriodEnd;
    }

    public void setGrossPay(double grossPay){
        this.grossPay = grossPay;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    public LocalDate getPayPeriodStart() {
        return payPeriodStart;
    }

    public LocalDate getPayPeriodEnd() {
        return payPeriodEnd;
    }

    public void setPayNet(double payNet) {
        this.payNet = payNet;
    }

    public double getPayNet() {
        return payNet;
    }
}
