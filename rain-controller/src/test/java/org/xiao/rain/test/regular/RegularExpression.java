package org.xiao.rain.test.regular;

/**
 * Author: xiaojl
 * Date: 2021/6/28 11:51
 */
public class RegularExpression {

    public static void main(String[] args) {
        
        String str = "4340611932949014这个是个xxxxxxxxx";
        boolean ismatch = str.matches("4340611932949014(?!.*(利息收入)).*");
        System.out.println("是否匹配：" + (ismatch?"是":"否"));
        
        String key = "4340611932949014[not like]%利息收入%";
        
    }
}
