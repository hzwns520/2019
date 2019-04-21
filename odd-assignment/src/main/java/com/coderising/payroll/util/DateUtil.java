package com.coderising.payroll.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by huangzhengwei on 2019-04-21.
 *
 * @Desciption:时间日期工具类
 */
public class DateUtil {

    public static  long getDaysBetween(Date d1, Date d2){
        return (d2.getTime() - d1.getTime()) / (24*60*60*1000);
    }


    public static boolean isFriday(LocalDate d){
        DayOfWeek dayOfWeek = d.getDayOfWeek();
        return dayOfWeek.getValue()==5;

    }

    public static LocalDate parseDate(String txtDate){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(txtDate, dateTimeFormatter);
        return date;
    }

    public static boolean between(LocalDate saleDate, LocalDate periodStartDate, LocalDate periodEndDate){

        return  saleDate.isAfter(periodStartDate) && saleDate.isBefore(periodEndDate);
    }
}
