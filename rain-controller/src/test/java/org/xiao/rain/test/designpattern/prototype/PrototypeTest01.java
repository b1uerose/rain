package org.xiao.rain.test.designpattern.prototype;

import org.junit.Test;

/**
 * Author: xiaojl
 * Date: 2021/8/23 07:30
 */
public class PrototypeTest01 {
    
    @Test
    public void cloneTest01() throws CloneNotSupportedException {
        
        Sheep duoli = new Sheep();
        duoli.setName("多利");
        Sheep cloneSheep1 = duoli.clone();
//        cloneSheep1.setName("克隆羊1号");
        System.out.println(duoli.getName() == cloneSheep1.getName());
        System.out.println(duoli);
        System.out.println(cloneSheep1);
        
    }
}


class Sheep implements Cloneable {
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Sheep's name is :" + this.getName();
    }

    @Override
    protected Sheep clone() throws CloneNotSupportedException {
        return (Sheep) super.clone();
    }
}
