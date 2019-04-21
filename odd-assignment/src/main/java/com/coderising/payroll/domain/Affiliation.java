package com.coderising.payroll.domain;

/**
 *
 * @author huangzhengwei
 * @date 2019-04-21
 *
 * @Desciption:会员接口
 */
public interface Affiliation {

    public double calculateDeductions(Paycheck pc);
}
