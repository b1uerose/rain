package org.xiao.rain.test.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: xiaojl
 * Date: 2021/6/29 01:23
 */
public class DateTest02 {

    public static void main(String[] args) {
        //1970-01-01 到现在的时间
        long startTime = System.currentTimeMillis();
        System.out.println(startTime);
        
        long ts = 1639152000000L;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        try {
            Date date = sdf.parse("2012-11-11 11:11:11");
            System.out.println(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(sdf.format(new Date(ts)));
        ts = 1639065600000L;
        System.out.println(sdf.format(new Date(ts)));
    }
}
