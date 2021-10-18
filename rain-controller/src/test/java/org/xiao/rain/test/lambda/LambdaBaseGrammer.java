package org.xiao.rain.test.lambda;

import org.junit.Test;

/**
 * lambda基础语法
 * Author: xiaojl
 * Date: 2021/9/13 10:42
 */
public class LambdaBaseGrammer {

    @Test
    public void test() throws Exception {

        ILambdaNoReturnNoParameter lambda1 = () -> {
            System.out.println("hello lambda");
        };
        
        lambda1.test();

        ILambdaNoReturnSingleParameter lambda2 = (int a) -> {
            System.out.println("一个参数,无返回值lambda");
            System.out.println("传入的值：" + a);
        };
        
        lambda2.test(100);
        
        ILambdaNoReturnMultiParameter lambda3 = (int a, int b) -> {
            int result = a + b;
            System.out.println("多参数,无返回值lambda");
            System.out.println("结果：" + result);
            
        };

        lambda3.test(100, 200);
        
        ILambdaHasReturnNoParameter lambda4 = () -> {
            return 10001;
        };
        
        int ret1 = lambda4.test();
        System.out.println("无参有返回值，返回值：" + ret1);
        
        ILambdaHasReturnSingleParameter lambda5 = (int a) -> {
            return a*100;
        };
        
        int ret2 = lambda5.test(100);
        System.out.println("一个参数，有返回值：" + ret2);

        ILambdaHasReturnMultiParameter lambda6 = (int a, int b) -> {
            return a + b;
        };
        
        int ret3 = lambda6.test(10, 20);
        System.out.println("多个参数，有返回值：" + ret3);
    }
}
