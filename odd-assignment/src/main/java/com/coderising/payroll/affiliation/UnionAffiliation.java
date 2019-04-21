package com.coderising.payroll.affiliation;

import com.coderising.payroll.domain.Affiliation;
import com.coderising.payroll.domain.Paycheck;

/**
 * Created by huangzhengwei on 2019-04-21.
 *
 * @Desciption:
 */
public class UnionAffiliation implements Affiliation {
    @Override
    public double calculateDeductions(Paycheck pc) {
        return 0;
    }
}
