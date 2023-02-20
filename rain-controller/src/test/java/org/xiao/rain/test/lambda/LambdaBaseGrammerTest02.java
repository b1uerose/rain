package org.xiao.rain.test.lambda;

import org.junit.Test;

/**
 * Author: xiaojl
 * Date:2022-05-02 16:12
 */
public class LambdaBaseGrammerTest02 {
    
    @Test
    public void test() {
        
        ILambdaHasReturnNoParameter lambda1 = ()->100;
        ILambdaHasReturnNoParameter lambda2 = () -> {
            int a = 100;
            int b = a*100;
            return b;
        };

        System.out.println(lambda1.test());
        System.out.println(lambda2.test());
        
        ILambdaNoReturnNoParameter lambda3 = () -> 
            System.out.println("没有参数没有返回值的lambda表达式");
        
        lambda3.test();
        
        ILambdaNoReturnSingleParameter lambda4 = a -> {
            System.out.println(a);
            System.out.println("只有一个参数，没有返回值的lambda表达式，可以去掉参数列表的括号");
        };
        lambda4.test(100);
        
        ILambdaNoReturnMultiParameter lambda5 = (a, b) -> {
            System.out.println(a);
            System.out.println(b);
            System.out.println("有多个参数没有返回值的lambda表达式");
        };
        lambda5.test(100, 200);
        
        
        
        
    }
 }
