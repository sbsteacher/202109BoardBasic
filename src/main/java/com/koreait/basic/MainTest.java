package com.koreait.basic;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainTest {
    public static void main(String[] args) throws  java.text.ParseException {
        String dealDate = null;

        String year = Integer.toString(2019);
        String mon = Integer.toString(1);
        String day = Integer.toString(2);

        String strDate = year + mon + day;

        try {
            Date timestamp = new SimpleDateFormat("yyyyMd").parse(strDate);
            dealDate = new SimpleDateFormat("yyyy-MM-dd").format(timestamp);
            System.out.println(dealDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
