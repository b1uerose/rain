package org.xiao.rain.test.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: xiaojl
 * Date: 2021/9/13 12:12
 */
public class LambdaExercise {

    @Test
    public void test1() throws Exception {
        List<LambdaPerson> list1 = new ArrayList<LambdaPerson>();
        list1.add(new LambdaPerson("xiaojl", 34));
        list1.add(new LambdaPerson("lilei", 11));
        list1.add(new LambdaPerson("hanmeimei", 22));
        list1.add(new LambdaPerson("lucy", 18));
        list1.add(new LambdaPerson("polly", 46));

//        list1.sort((o1, o2) -> o1.getAge() - o2.getAge());
//
//        System.out.println(list1);

        list1.removeIf(ele -> ele.getAge() > 40);
        System.out.println(list1);

    }


}
