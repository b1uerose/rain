package org.xiao.rain.test.datastructure.divideandconquer;

import org.junit.Test;

/**
 * 步骤 2的n次方-1
 * 汉诺塔 - 分治算法
 * Author: xiaojl
 * Date:2022-03-12 16:58
 */
public class HanoiTower {
    
    @Test
    public void test() {
        hanoiTower(3, 'A', 'B', 'C');
    }
    
    
    public void hanoiTower(int num, char origin, char assist, char destination) {
        
        if(num == 1) {
            move(origin, destination);
        } else {
            hanoiTower(num - 1, origin, destination, assist);
            move(origin, destination);
            hanoiTower(num - 1, assist, origin, destination);
        }
    }
    
    private void move(char origin, char destination) {
        System.out.println(origin + " -> " + destination);
    }
}
