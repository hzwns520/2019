package com.coderising.payroll.transaction;

import com.coderising.payroll.domain.*;

/**
 * Created by huangzhengwei on 2019-04-21.
 *
 * @Desciption:
 */
public abstract class AddEmployeeTransaction {

    private String name;

    private String address;

    public AddEmployeeTransaction(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public abstract PaymentCalssification getClassification();

    public abstract PaymentSchedule getSchedule();

    public void execute(){
        PaymentSchedule schedule = getSchedule();
        PaymentCalssification calssification = getClassification();
        PaymentMethod pm = new HoldMethod();
        Employee e = new Employee(name, address);
        e.setPaymentCalssification(calssification);
        e.setPaymentSchedule(schedule);
        e.setPaymentMethod(pm);
    }
}
