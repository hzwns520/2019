package com.coderising.payroll;

import com.coderising.payroll.affiliation.NonAffiliation;
import com.coderising.payroll.classification.CommissionedClassification;
import com.coderising.payroll.classification.HourlyClassification;
import com.coderising.payroll.classification.SalariedClassification;
import com.coderising.payroll.domain.*;
import com.coderising.payroll.schedule.BiweeklySchedule;
import com.coderising.payroll.schedule.MonthlySchedule;
import com.coderising.payroll.schedule.WeeklySchedule;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 * Created by huangzhengwei on 2019-04-21.
 *
 * @Desciption:薪水支付案例测试用例
 */
public class PayrollTest {


    //Payroll payroll = null;
    //@Before
    //public void setUp() throws Exception {
    //    payroll = new Payroll();
    //}

    //@After
    //public void tearDown() throws Exception {
    //    payroll = null;
    //}

    @Test
    public void testPayMonthlyEmployee() throws Exception{
        String[][] commands = new String[][] {
                { "AddMonthlyEmployee", "emp101", "Bob", "Beijing", "1000.0" },
                { "AddMonthlyEmployee", "emp102", "Joe", "Beijing", "2000.0" }
        };
        Employee e = new Employee( "Bob", "BeiJing");
        PaymentSchedule schedule = new MonthlySchedule();
        LocalDate payDate = LocalDate.of(2019, 4, 30);
        PaymentMethod pm = new HoldMethod();
        PaymentCalssification calssification = new SalariedClassification(1000);
        Affiliation affiliation = new NonAffiliation();
        e.setPaymentMethod(pm);
        e.setPaymentSchedule(schedule);
        e.setPaymentCalssification(calssification);
        e.setAffiliation(affiliation);
        if(e.isPayDay(payDate)){
            Paycheck pc = new Paycheck(e.getPayPeroidStartDate(payDate), payDate);
            e.payDay(pc);
            Assert.assertEquals(java.util.Optional.ofNullable(Double.valueOf(1000.0)),java.util.Optional.ofNullable(pc.getPayNet()));
        }

        //Assert.assertEquals(Double.valueOf(1000.0), e.);

        //payroll.parse(commands);
        //
        //
        //Date payDay = parseDate("2019-4-30");
        //Map<String, Double> payments = payroll.payFor(payDay);
        //Assert.assertEquals(2, payments.size());
        //Assert.assertEquals(Double.valueOf(1000.0), payments.get("emp101"),0.001);
        //Assert.assertEquals(Double.valueOf(2000.0), payments.get("emp102"),0.001);

    }

    @Test
    public void testPayHourlyEmployee() throws Exception{
        String[][] commands = new String[][] {
                { "AddMonthlyEmployee", "emp101", "Bob", "Beijing", "1000.0" },
                { "AddMonthlyEmployee", "emp102", "Joe", "Beijing", "2000.0" }
        };
        Employee e = new Employee( "Bob", "BeiJing");
        PaymentSchedule schedule = new WeeklySchedule();
        LocalDate payDate = LocalDate.of(2019, 4, 30);
        PaymentMethod pm = new HoldMethod();
        PaymentCalssification calssification = new HourlyClassification(12.5);
        TimeCard tc = new TimeCard(payDate, 4);
        ((HourlyClassification) calssification).addTimeCard(tc);
        Affiliation affiliation = new NonAffiliation();
        e.setPaymentMethod(pm);
        e.setPaymentSchedule(schedule);
        e.setPaymentCalssification(calssification);
        e.setAffiliation(affiliation);
        if(e.isPayDay(payDate)){
            Paycheck pc = new Paycheck(e.getPayPeroidStartDate(payDate), payDate);
            e.payDay(pc);
            Assert.assertEquals(java.util.Optional.ofNullable(Double.valueOf(50.0)),java.util.Optional.ofNullable(pc.getPayNet()));
        }

    }
    //@Test
    //public void testChangeEmployeeType() throws Exception {
    //
    //    String[][] commands = new String[][] {
    //            { "AddMonthlyEmployee", "emp101", "Bob", "Beijing", "1000" }};
    //
    //
    //    payroll.parse(commands);
    //
    //    Date payDay = parseDate("2019-4-30");
    //    Map<String, Double> payments = payroll.payFor(payDay);
    //
    //
    //    Assert.assertEquals(1, payments.size());
    //    Assert.assertEquals(Double.valueOf(1000), payments.get("emp101"),0.01);
    //
    //    commands = new String[][] { { "ChangeToHourlyEmployee", "emp101", "25.0" } };
    //
    //    payroll.parse(commands);
    //
    //    payments = payroll.payFor(payDay);
    //    Assert.assertEquals(0, payments.size());
    //
    //}
    //
    //public Date parseDate(String s) throws ParseException {
    //    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    //    return sdf.parse(s);
    //}

}

