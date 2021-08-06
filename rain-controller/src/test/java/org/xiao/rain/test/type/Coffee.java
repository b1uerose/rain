package org.xiao.rain.test.type;

/**
 * Author: xiaojl
 * Date: 2021/7/20 00:14
 */
public class Coffee {
    private static int counter = 0;
    private final int id = counter++;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "id=" + id +
                '}';
    }
}

class Latte extends Coffee {}
class Mocha extends Coffee {}
class Cappuccino extends Coffee {}
