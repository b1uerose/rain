package org.xiao.rain.test.enum2;

/**
 * Author: xiaojl
 * Date: 2021/6/29 01:56
 */
public class EnumTest01 {
    public static void main(String[] args) {
        
        Season season = getSeason();

        System.out.println(season==Season.SPRING?"春天":"其他季节");
        
    }
    
    public static Season getSeason() {
        
        
        return Season.WINTER;
        
    }
}
