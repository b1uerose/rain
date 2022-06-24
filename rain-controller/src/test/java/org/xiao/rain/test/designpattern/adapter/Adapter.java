package org.xiao.rain.test.designpattern.adapter;

/**
 * 适配器
 * Author: xiaojl
 * Date: 2021/8/24 23:00
 */
public class Adapter extends Source implements ITarget{

    @Override
    public void targetOutPut() {
        int src = outPut();
        System.out.println("转换了：" + src/100);
    }
}
