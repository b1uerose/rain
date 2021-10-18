package org.xiao.rain.test.designpattern.decorator;

/**
 * 具体的装饰器
 * Author: xiaojl
 * Date: 2021/8/26 07:46
 */
public class Pearl extends Decorator {
    public Pearl(IDrink drink) {
        super(drink);
        setMny(10);
        setDescription("珍珠");
    }
}
