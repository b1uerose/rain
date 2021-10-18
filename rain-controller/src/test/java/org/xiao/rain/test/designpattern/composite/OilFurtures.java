package org.xiao.rain.test.designpattern.composite;

import java.util.Observable;

/**
 * 观察者模式中的目标类
 * Author: xiaojl
 * Date: 2021/8/31 23:25
 */
public class OilFurtures extends Observable {
    
    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
        this.setChanged();
        this.notifyObservers(price);
    }
}
