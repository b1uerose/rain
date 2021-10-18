package org.xiao.rain.test.designpattern.birdge;

/**
 * RefinedAbatraction
 * Author: xiaojl
 * Date: 2021/8/25 22:53
 */
public class Triangle extends AbstractShape{
    public Triangle(IColor color) {
        super(color);
    }

    @Override
    public void show() {
        System.out.println(this.getClass().getSimpleName() +" with beautiful " + getColor());
    }

}
