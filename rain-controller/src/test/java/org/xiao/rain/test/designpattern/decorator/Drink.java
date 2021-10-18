package org.xiao.rain.test.designpattern.decorator;

/**
 * Author: xiaojl
 * Date: 2021/8/26 07:31
 */
public abstract class Drink implements IDrink {
    private double mny = 0;
    private String description = "";

    public double getMny() {
        return mny;
    }

    public void setMny(double mny) {
        this.mny = mny;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
