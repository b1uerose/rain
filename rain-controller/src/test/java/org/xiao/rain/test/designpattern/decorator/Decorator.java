package org.xiao.rain.test.designpattern.decorator;

/**
 * 抽象装饰器
 * Author: xiaojl
 * Date: 2021/8/26 07:28
 */
public abstract class Decorator extends Drink {
    
    private IDrink drink;
    public Decorator(IDrink drink) {
        this.drink = drink;
    }

    @Override
    public double calcCostMny() {
        return getMny() + drink.calcCostMny();
    }
}
