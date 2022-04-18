package org.xiao.rain.test.datastructrue.prim;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 普里姆算法 
 * 构造最小生成树
 * Author: xiaojl
 * Date:2022-04-12 22:58
 */
public class PrimAlgorithm {
    
    @Test
    public void primAlgorithm() {
        
        //有七个村庄 ABCDEFG
        int villageSize = 7;
        int[][] villageLength = new int[villageSize][villageSize];
        
        int A = 0;
        int B = 1;
        int C = 2;
        int D = 3;
        int E = 4;
        int F = 5;
        int G = 6;

        villageLength[A][B] = 5;
        villageLength[A][C] = 7;
        villageLength[A][G] = 2;
        
        villageLength[B][A] = 5;
        villageLength[B][D] = 9;
        villageLength[B][G] = 3;
        
        villageLength[C][A] = 7;
        villageLength[C][E] = 8;
        
        villageLength[D][B] = 9;
        villageLength[D][F] = 4;
        
        villageLength[E][C] = 8;
        villageLength[E][F] = 5;
        villageLength[E][G] = 4;
        
        villageLength[F][D] = 4;
        villageLength[F][E] = 5;
        villageLength[F][G] = 5;
        
        villageLength[G][A] = 2;
        villageLength[G][B] = 3;
        villageLength[G][E] = 4;
        villageLength[G][F] = 6;
        
        List<String> villageNameList = new ArrayList<>();
        villageNameList.add("A");
        villageNameList.add("B");
        villageNameList.add("C");
        villageNameList.add("D");
        villageNameList.add("E");
        villageNameList.add("F");
        villageNameList.add("G");
        
        List<Integer> visitedList = new ArrayList<Integer>();
        visitedList.add(A);

        while (visitedList.size() < villageSize) {
            int minLength = Integer.MAX_VALUE;
            int startIndex = 0;
            int endIndex = 0;
            for (int visitedVillage : visitedList) {
                for (int i = 0; i < villageSize; i++) {
                    if (villageLength[visitedVillage][i] > 0 && minLength > villageLength[visitedVillage][i] && !visitedList.contains(i)) {
                        minLength = villageLength[visitedVillage][i];
                        startIndex = visitedVillage;
                        endIndex = i;
                    }
                }
            }
            visitedList.add(endIndex);
            System.out.println(villageNameList.get(startIndex) +"->"+villageNameList.get(endIndex) +"。长度:" + villageLength[startIndex][endIndex]);
        }
        
        
        
    }
}
