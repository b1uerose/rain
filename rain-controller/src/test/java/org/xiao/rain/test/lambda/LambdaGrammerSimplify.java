package org.xiao.rain.test.lambda;

import org.junit.Test;

/**
 * lambda表达式简化
 * Author: xiaojl
 * Date: 2021/9/13 11:04
 */
public class LambdaGrammerSimplify {
    
    @Test
    public void test() throws Exception {
        ILambdaHasReturnMultiParameter lambda1 = LambdaGrammerSimplify::sum;
        
        ILambdaNoReturnSingleParameter lambda2 = a -> System.out.println("hello");
        
    }
    
    
    private static int sum(int a, int b) {
        return a + b;
    }
    
}
