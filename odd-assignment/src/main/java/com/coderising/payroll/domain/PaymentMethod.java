package com.coderising.payroll.domain;

/**
 * Created by huangzhengwei on 2019-04-21.
 *
 * @Desciption:
 */
public interface PaymentMethod {
    void pay(Paycheck pc);
}
