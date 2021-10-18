package org.xiao.rain.test.designpattern.decorator;

/**
 * 具体组件
 * Author: xiaojl
 * Date: 2021/8/26 07:26
 */
public class MilkTea extends Drink {
    
    public MilkTea() {
        setMny(20);
        setDescription("奶茶");
    }

    @Override
    public double calcCostMny() {
        return getMny();
    }
}
