package org.xiao.rain.test.thread.timmer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器
 * Author: xiaojl
 * Date: 2021/7/7 22:45
 */
public class TimmerTest01 {
    public static void main(String[] args) throws Exception {
        Timer timer = new Timer();
        String execTime = "2021-07-07 22:54:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date execDate = sdf.parse(execTime);
        timer.schedule(new BackUpTimerTask(), execDate, 10*1000);
    }
}

class BackUpTimerTask extends TimerTask {

    @Override
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = sdf.format(new Date());
        System.out.println(date+"完成了一次数据备份");
    }
}
