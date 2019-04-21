package com.coderising.payroll.classification;

import com.coderising.payroll.domain.Paycheck;
import com.coderising.payroll.domain.PaymentCalssification;
import com.coderising.payroll.domain.TimeCard;
import com.coderising.payroll.util.DateUtil;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangzhengwei on 2019-04-21.
 *
 * @Desciption:
 */
public class HourlyClassification implements PaymentCalssification {

    private double rate;

    private Map<LocalDate, TimeCard> timeCardMap = new HashMap<>();
    @Override
    public double calculatePay(Paycheck pc) {
        // 兼职计算工资
        double totalPay = 0;
        for (TimeCard tc : timeCardMap.values()) {
            if(DateUtil.between(tc.getDate(), pc.getPayPeriodStart(), pc.getPayPeriodEnd())){
                totalPay +=calculatePayForTimeCard(tc);
            }
        }
        return totalPay;
    }

    public HourlyClassification(double rate) {
        this.rate = rate;
    }

    public void addTimeCard(TimeCard tc){
        timeCardMap.put(tc.getDate(), tc);
    }


    public double calculatePayForTimeCard(TimeCard tc){
        int hours = tc.getHours();

        if(hours > 9){
            return 8*rate + (hours - 8)*rate*1.5;
        }else {
            return 8*rate;
        }
    }
}
