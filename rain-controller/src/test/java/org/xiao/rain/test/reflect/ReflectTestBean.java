package org.xiao.rain.test.reflect;

/**
 * Author: xiaojl
 * Date: 2021/7/12 22:12
 */
public class ReflectTestBean {
    
    private int no;
    private String name;
    private double balancd;

    public ReflectTestBean(int no, String name, double balancd) {
        this.no = no;
        this.name = name;
        this.balancd = balancd;
    }

    public ReflectTestBean() {
        
    }

    @Override
    public String toString() {
        return "ReflectTestBean{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", balancd=" + balancd +
                '}';
    }
}
