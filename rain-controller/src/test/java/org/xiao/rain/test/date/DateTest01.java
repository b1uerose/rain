package org.xiao.rain.test.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date转string 和 string转date
 * Author: xiaojl
 * Date: 2021/6/29 01:06
 */
public class DateTest01 {

    public static void main(String[] args) {
        Date date = new Date();
        
        //日期格式化
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hha:mm:ss SSS");
        String dateStr = format.format(date);
        System.out.println(dateStr);
        
        //下面的格式要一致
        String pastDateStr = "2008-08-08 08:08:08 888";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyy-MM-dd HH:mm:ss SSS");

        try {
            Date pastDate = sdf2.parse(pastDateStr);
            System.out.println(pastDate);
        } catch (ParseException e) {
        }
    }
}
