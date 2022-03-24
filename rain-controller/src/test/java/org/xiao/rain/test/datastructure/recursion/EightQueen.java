package org.xiao.rain.test.datastructure.recursion;

/**
 * 八皇后
 * 8x8的棋盘 任意两个皇后不能处于棋盘的同一行、同一列和同一条对角线上
 * Author: xiaojl
 * Date: 2021/11/11 22:41
 */
public class EightQueen {
    
    private int count = 0;

    public static void main(String[] args) {
        EightQueen queen = new EightQueen();
        for (int i = 0; i < 8; i++) {
            int[] arrays = new int[8];
            arrays[0] = i;
            queen.findIndex(arrays, 1);
        }

        System.out.println(queen.count);
    }
    
    private void findIndex(int[] arrays, int level) {
        if(level >= 8) {
            for (int result : arrays) {
                System.out.print(result + 1 +" ");
                
            }
            System.out.println(" ");
            count ++;
            return;
        }
//        boolean isAllFailure = true;
        //总共有8类，循环找
        for (int index = 0; index < 8; index++) {
            //前面的行的皇后的位置
            //不能和前面行的皇后处于同一列，也不能除以对角线上
            boolean isCheckPass = true;
            for (int uponIndex = 0; uponIndex < level; uponIndex++) {
                int comparedvalue = arrays[uponIndex];
                if(index == comparedvalue || level-uponIndex == Math.abs(index-comparedvalue)) {
                    isCheckPass = false;
                    break;
//                    isAllFailure = false;
//                    arrays[level] = index;
//                    findIndex(arrays, level+1);
                }
                
            }
            
            if(isCheckPass) {
                arrays[level] = index;
                findIndex(arrays, level+1);
            }
            
        }
        
        
        
        
    } 
    
    
    
}
