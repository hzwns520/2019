package com.coderising.payroll.classification;

import com.coderising.payroll.domain.Paycheck;
import com.coderising.payroll.domain.PaymentCalssification;
import com.coderising.payroll.domain.SalesReceipt;
import com.coderising.payroll.util.DateUtil;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

/**
 * Created by huangzhengwei on 2019-04-21.
 *
 * @Desciption:
 */
public class CommissionedClassification implements PaymentCalssification {
    double salary;
    double rate;

    public CommissionedClassification(double salary, double rate) {
        this.salary = salary;
        this.rate = rate;
    }

    Map<LocalDate, SalesReceipt> receiptMap;

    @Override
    public double calculatePay(Paycheck pc) {
        // 计算规则，基本工资加上销售提点
        double commission = 0.0;
        for (SalesReceipt salesReceipt : receiptMap.values()) {
            if(DateUtil.between(salesReceipt.getSaleDate(), pc.getPayPeriodStart(), pc.getPayPeriodEnd())){
                commission += salesReceipt.getAmount() * rate;
            }
        }
        return salary + commission;
    }
}
