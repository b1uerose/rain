package org.xiao.rain.test.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/**
 * lambda表达式
 * Author: xiaojl
 * Date: 2021/9/13 07:39
 */
public class LambdaTest01 {

    IComparetor comparetor1 = new MyCompareTor();
    
    IComparetor comparetor2 = new IComparetor() {
        @Override
        public int compare(int a, int b) {
            return a - b;
        }
    };
    
    //lambda表达式来实现接口
    IComparetor comparetor3 = (a, b)-> a - b;
    
    @Test
    public void test2() throws Exception {

        List<Integer> list1 = new ArrayList<Integer>();
        Collections.addAll(list1, 1,2,3,4,5,6,7,8,9,10);
        
        list1.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        System.out.println("==============");
        list1.forEach(System.out::println);
    }
    
}


class MyCompareTor implements IComparetor {
    @Override
    public int compare(int a, int b) {
        return a - b;
    }
}

@FunctionalInterface
interface IComparetor {
    public int compare(int a, int b);
}
