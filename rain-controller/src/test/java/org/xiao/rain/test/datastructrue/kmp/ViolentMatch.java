package org.xiao.rain.test.datastructrue.kmp;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 暴力匹配
 * Author: xiaojl
 * Date:2022-03-31 23:19
 */
public class ViolentMatch {
    
    @Test
    public void violentMatch() {
        
        String oriStr = "woshiyizhixiaoxiaoniao";
        
        String searchStr = "xiao";
        
        int oriStrLength = oriStr.length();
        int searchStrLength = searchStr.length();

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < oriStrLength; i++) {
            int startIndex = i;
            for (int j = 0; j < searchStrLength; j++) {
                if(oriStr.charAt(startIndex) == searchStr.charAt(j)) {
                    startIndex++;
                } else {
                    break;
                }
                if (j == searchStrLength-1) {
                    list.add(i);
                    i = i + searchStrLength-1;
                }
            }
        }

        System.out.println(list.toString());
        
    }
}
