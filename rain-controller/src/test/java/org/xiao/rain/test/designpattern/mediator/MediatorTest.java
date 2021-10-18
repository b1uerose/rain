package org.xiao.rain.test.designpattern.mediator;

import org.junit.Test;

/**
 * Author: xiaojl
 * Date: 2021/9/1 12:44
 */
public class MediatorTest {
    
    @Test
    public void test() throws Exception {
        
        AbstractMediator mediator = new Mediator();
        AbstractColleague colleague1 = new ConcreteColleague1();
        AbstractColleague colleague2 = new ConcreteColleague2();
        mediator.register(colleague1);
        mediator.register(colleague2);


        colleague1.send();
        System.out.println("================");
        colleague2.send();
        
    }
    
}
