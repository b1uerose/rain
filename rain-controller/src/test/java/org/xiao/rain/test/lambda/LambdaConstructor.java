package org.xiao.rain.test.lambda;

import org.junit.Test;

/**
 * lambda表达式调用构造函数
 * Author: xiaojl
 * Date: 2021/9/13 11:29
 */
public class LambdaConstructor {
    
    @Test
    public void test() throws Exception {
        PersontCreater creater = () -> new LambdaPerson();  
        PersontCreater creater2 = LambdaPerson::new;
        System.out.println("============");
        LambdaPerson person = creater2.getPerson();
        
        PersontCreater2 creater21 = LambdaPerson::new;
        System.out.println("===============");
        creater21.getPerson("xiaojl", 18);
    }
}

interface PersontCreater {
    
    LambdaPerson getPerson();
}

interface PersontCreater2 {

    LambdaPerson getPerson(String name, int age);
}
