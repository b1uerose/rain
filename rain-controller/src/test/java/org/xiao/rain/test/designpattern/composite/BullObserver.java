package org.xiao.rain.test.designpattern.composite;

import java.util.Observable;
import java.util.Observer;

/**
 * 多方观察者
 * Author: xiaojl
 * Date: 2021/8/31 23:28
 */
public class BullObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        float price = (Float) arg;
        if(price>0) {
            System.out.println("价格上升了" + price +",多头要笑死了");
        } else {
            System.out.println("价格下跌了" + (-price) +",多头要哭死了");
        }
    }
}
