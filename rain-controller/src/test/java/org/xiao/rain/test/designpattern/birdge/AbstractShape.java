package org.xiao.rain.test.designpattern.birdge;

/**
 * 抽象化
 * Author: xiaojl
 * Date: 2021/8/25 22:49
 */
public abstract class AbstractShape {
    
    private IColor color;
    
    public AbstractShape(IColor color) {
        this.color = color;
    }
    
    protected String getColor() {
        return this.color.getColor();
    }
    
    public abstract void show();
}
