package org.xiao.rain.test.designpattern.decorator;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试用例
 * Author: xiaojl
 * Date: 2021/8/26 07:48
 */
public class DecoratorTest {

    @Test
    public void test() throws Exception {

        System.out.println(System.currentTimeMillis());
        IDrink milkTea = new MilkTea();
        //加一分珍珠
        milkTea = new Pearl(milkTea);
        milkTea = new Pearl(milkTea);

        System.out.println("总价：" + milkTea.calcCostMny());

    }

    @Test
    public void test2() throws Exception {
//        String appKey = "APPKEY"; //这里输入提供的app_key  
//        String appSecret = "APPSECRET"; //这里输入提供的app_secret    
//
//        String imageUrl = "http://fapiao.glority.cn/dist/img/sample.jpg";
//        String host = "http://fapiao.glority.cn/v1/item/get_item_info";
//        long timestamp = System.currentTimeMillis() / 1000;
//        String token = new Md5Hash(appKey + "+" + timestamp + "+" + appSecret).toString();
//
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url(host)
//                .post(new FormBody.Builder()
//                        .add("app_key", appKey)
//                        .add("timestamp", String.valueOf(timestamp))
//                        .add("token", token)
//                        .add("image_url", imageUrl)
//                        .build())
//                .build();
//
//        Response response = client.newCall(request).execute();
//        System.out.println(response.body().string());
    }
    
    @Test
    public void test3() throws Exception {
        SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy年MM月dd日");
        SimpleDateFormat sourceFormat = new SimpleDateFormat("yyyyMMdd");
        
        String date = "20210827";

        Date date2 = sourceFormat.parse(date);
        System.out.println(targetFormat.format(date2));
    }
}
