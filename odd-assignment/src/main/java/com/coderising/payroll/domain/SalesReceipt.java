package com.coderising.payroll.domain;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by huangzhengwei on 2019-04-21.
 *
 * @Desciption:
 */
public class SalesReceipt {

    private LocalDate saleDate;

    private double amount;

    public LocalDate getSaleDate(){
        return saleDate;
    }

    public double getAmount(){
        return amount;
    }
}
