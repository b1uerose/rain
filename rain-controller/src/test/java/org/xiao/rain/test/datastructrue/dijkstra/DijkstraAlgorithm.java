package org.xiao.rain.test.datastructrue.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 迪杰斯特拉
 * 求一个顶点到其他顶点的最短路径
 * 
 * Author: xiaojl
 * Date:2022-04-15 08:03
 */
public class DijkstraAlgorithm {
    
    public void dijkstra() {
        String[] villages = new String[]{"A", "B", "C", "D", "E", "F", "G"};
        int[][] matrix = new int[villages.length][villages.length];
        matrix[0]=new int[]{0,5,7,0,0,0,2};
        matrix[1]=new int[]{5,0,0,9,0,0,3};
        matrix[2]=new int[]{7,0,0,0,8,0,0};
        matrix[3]=new int[]{0,9,0,0,0,4,0};
        matrix[4]=new int[]{0,0,8,0,0,5,4};
        matrix[5]=new int[]{0,0,0,4,5,0,6};
        matrix[6]=new int[]{2,3,0,0,4,6,0};

        List<String> visitedVillages = new ArrayList<>();
        visitedVillages.add(villages[0]);

        //key:  value:
        Map<String, Integer> lengthMap = new HashMap<String, Integer>();
        lengthMap.put("A", 0);
//        while (vi)
        for (int i = 0; i < visitedVillages.size(); i++) {
            for (int j = 0; j < villages.length; j++) {
                if (matrix[i][j] > 0) {
                    
                }
            }
            
            
        }
        
        
        
        
    }
    
}
