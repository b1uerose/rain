package org.xiao.rain.test.designpattern.composite;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者-空头
 * Author: xiaojl
 * Date: 2021/8/31 23:30
 */
public class BearObserver implements Observer {
    
    @Override
    public void update(Observable o, Object arg) {
        float price = (Float) arg;
        if(price>0) {
            System.out.println("价格上升了" + price +",空头要哭死了");
        } else {
            System.out.println("价格下跌了" + (-price) +",空头要笑死了");
        }
    }
}
