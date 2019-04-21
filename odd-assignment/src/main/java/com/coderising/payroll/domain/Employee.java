package com.coderising.payroll.domain;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by huangzhengwei on 2019-04-21.
 *
 * @Desciption:
 */
public class Employee {

    private PaymentMethod paymentMethod ;

    private Affiliation affiliation;

    private PaymentCalssification paymentCalssification;

    private PaymentSchedule paymentSchedule;

    private String id;

    private String name;

    private String address;

    public Employee(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public boolean isPayDay(LocalDate d){
        return this.paymentSchedule.isPayDate(d);
    }

    public LocalDate getPayPeroidStartDate(LocalDate d){
        return this.paymentSchedule.getPayPeriodStartDate(d);
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    public void setPaymentCalssification(PaymentCalssification paymentCalssification) {
        this.paymentCalssification = paymentCalssification;
    }

    public void setPaymentSchedule(PaymentSchedule paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    public void setAffiliation(Affiliation affiliation) {
        this.affiliation = affiliation;
    }

    public void payDay(Paycheck pc){
        double grossPay = paymentCalssification.calculatePay(pc);
        double deductions = affiliation.calculateDeductions(pc);
        double netPay = grossPay - deductions;
        pc.setGrossPay(grossPay);
        pc.setDeductions(deductions);
        pc.setPayNet(netPay);
        paymentMethod.pay(pc);
    }
}
