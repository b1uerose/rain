package org.xiao.rain.test.datastructrue.kruskal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * 克鲁斯卡尔算法，构造最小生成树
 * 
 * Author: xiaojl
 * Date:2022-04-13 21:43
 */
public class KruskalAlgorithm {
    
    public class Route implements Comparable<Route> {
        String startVillage;
        String endVillage;
        int length;

        public String getStartVillage() {
            return startVillage;
        }

        public void setStartVillage(String startVillage) {
            this.startVillage = startVillage;
        }

        public String getEndVillage() {
            return endVillage;
        }

        public void setEndVillage(String endVillage) {
            this.endVillage = endVillage;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        @Override
        public int compareTo(Route o) {
            return length - o.getLength();
        }
    }
    
    @Test
    public void kruskal() throws Exception {
        
        String[] villages = new String[]{"A", "B", "C", "D", "E", "F", "G"};
        
        //邻接矩阵
        int[][] matrix = new int[][]
                {
                            /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                        /*A*/{0,   12,  0,   0,   0,  16,  14},
                        /*B*/{12,  0,   10,  0,   0,   7,   0},
                        /*C*/{0,   10,  0,   3,   5,   6,   0},
                        /*D*/{0,   0,   3,   0,   4,   0,   0},
                        /*E*/{0,   0,   5,   4,   0,   2,   8},
                        /*F*/{16,  7,   6,   0,   2,   0,   9},
                        /*G*/{14,  0,   0,   0,   8,   9,   0}
                };
//        boolean[][] visitedMatrix = new boolean[villages.length][villages.length];

        List<Route> list = new ArrayList<>();
        for (int i = 0; i < villages.length; i++) {
            for (int j = i+1; j < villages.length; j++) {
                if (matrix[i][j] > 0 ) {
                    Route route = new Route();
                    route.setStartVillage(villages[i]);
                    route.setEndVillage(villages[j]);
                    route.setLength(matrix[i][j]);
                    list.add(route);
                }
            }
        }

        Collections.sort(list);
//        Arrays.sort(list.toArray(new Route[0]));
        
        List<Route> linkedList = new LinkedList<>();
        //key:  value:
        Map<String, String> endMap = new HashMap<String, String>();
        
        //初始化map

        for (String village : villages) {
            endMap.put(village, village);
        }
        
        for (Route route : list) {
            if (linkedList.size() == villages.length - 1) {
                break;
            }
            String startvillage = route.getStartVillage();
            String endvillage = route.getEndVillage();
            
            String startEnd = getTerminalPoint(endMap, startvillage);
            String endend = getTerminalPoint(endMap, endvillage);
            
            if (!startEnd.equals(endend)) {
                endMap.put(startEnd, endend);
                linkedList.add(route);
            }
        }

        for (Route route : linkedList) {
            System.out.println(route.getStartVillage() +"->" + route.getEndVillage() + " : " + route.getLength());
        }
    }
    
    private String getTerminalPoint( Map<String, String> endMap, String village) {
        String startVillage = village;
        String endvillage = endMap.get(startVillage);
        while (!startVillage.equals(endvillage)) {
            startVillage = endvillage;
            endvillage = endMap.get(startVillage);
        }
        return endvillage;
    }
}
