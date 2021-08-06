package org.xiao.rain.test.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import org.junit.Test;

import java.util.Map;

/**
 * Author: xiaojl
 * Date: 2021/7/28 14:53
 */
public class FastJsonTest {
    
    @Test
    public void test() {
        
        String jsonArray = "{\"YXB1\":{\"报销总额\":\"nallpaymny,texpensemny\",\"垫付总额\":\"texpensemny\"}}";

        Map<String, JSONObject> map = JSON.parseObject(jsonArray, Map.class);
        Map<String, JSONObject> map2 = JSON.parseObject(jsonArray, Map.class, Feature.OrderedField);

        System.out.println();
        
    }
    
    
}
