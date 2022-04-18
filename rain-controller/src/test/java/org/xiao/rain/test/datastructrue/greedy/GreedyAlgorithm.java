package org.xiao.rain.test.datastructrue.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * 贪心算法
 * 1、解决集合覆盖问题
 * Author: xiaojl
 * Date:2022-04-09 10:26
 */
public class GreedyAlgorithm {

    @Test
    public void greedyAlgorithm() {

        //使用贪婪算法，效率高:
        //1) 目前并没有算法可以快速计算得到准备的值， 使用贪婪算法，则可以得到非常接近的解，并且效率高。选择
        //策略上，因为需要覆盖全部地区的最小集合:
        //2) 遍历所有的广播电台, 找到一个覆盖了最多未覆盖的地区的电台(此电台可能包含一些已覆盖的地区，但没有关
        //系）
        //3) 将这个电台加入到一个集合中(比如ArrayList), 想办法把该电台覆盖的地区在下次比较时去掉。
        //4) 重复第1 步直到覆盖了全部的地区


        //key:  value:
        Map<String, Set<String>> broadcastMap = new HashMap<String, Set<String>>();

        Set<String> areaSet1 = new HashSet<String>();
        areaSet1.add("北京");
        areaSet1.add("上海");
        areaSet1.add("天津");
        Set<String> areaSet2 = new HashSet<String>();
        areaSet2.add("广州");
        areaSet2.add("北京");
        areaSet2.add("深圳");
        Set<String> areaSet3 = new HashSet<String>();
        areaSet3.add("成都");
        areaSet3.add("上海");
        areaSet3.add("杭州");
        Set<String> areaSet4 = new HashSet<String>();
        areaSet4.add("上海");
        areaSet4.add("天津");
        Set<String> areaSet5 = new HashSet<String>();
        areaSet5.add("杭州");
        areaSet5.add("大连");

        broadcastMap.put("k1", areaSet1);
        broadcastMap.put("k2", areaSet2);
        broadcastMap.put("k3", areaSet3);
        broadcastMap.put("k4", areaSet4);
        broadcastMap.put("k5", areaSet5);

        Set<String> allAreaSet = new HashSet<String>();
        allAreaSet.addAll(areaSet1);
        allAreaSet.addAll(areaSet2);
        allAreaSet.addAll(areaSet3);
        allAreaSet.addAll(areaSet4);
        allAreaSet.addAll(areaSet5);
        
        List<String> coverBroadcastList = new ArrayList<String>();

        while (!allAreaSet.isEmpty()) {
            String maxkBroadCastId = null;
            int maxCount = 0;
            for (String broadcastId : broadcastMap.keySet()) {
                Set<String> areaSet = broadcastMap.get(broadcastId);
                int count = getMatchCount(allAreaSet, areaSet);
                if(count > maxCount) {
                    maxCount = count;
                    maxkBroadCastId = broadcastId;
                }
            }
            coverBroadcastList.add(maxkBroadCastId);
            allAreaSet.removeAll(broadcastMap.get(maxkBroadCastId));
        }
        System.out.println(coverBroadcastList);
    }

    private int getMatchCount(Set<String> allAreaSet, Set<String> areaSet) {
//        int count = 0;
//        for (String area : areaSet) {
//            if (allAreaSet.contains(area)) {
//                count++;
//            }
//        }
//        return count;
        
        Set<String> temset = new HashSet<String>();
        temset.addAll(areaSet);
        temset.retainAll(allAreaSet);
        return temset.size();
    }


}
