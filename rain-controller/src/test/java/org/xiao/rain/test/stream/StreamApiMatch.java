package org.xiao.rain.test.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

/**
 * Author: xiaojl
 * Date:2022-07-04 23:06
 */
public class StreamApiMatch {
    
    @Test
    public void test() throws Exception {

        Employee e1 = new Employee("jinlong", "xiao", "M", 35);
        Employee e2 = new Employee("yutong", "xiao", "F", 5);
        Employee e3 = new Employee("lu", "sun", "F", 33);
        Employee e4 = new Employee("xxx", "xiao", "M", 2);
        List<Employee> list = Arrays.asList(e1, e2, e3, e4);

        //是否存在
        boolean isExist = list.stream().anyMatch(employee -> employee.getAge() > 34);
        System.out.println(isExist);
        
        //是否所有元素都符合某个规则
        boolean allMatch = list.stream().allMatch(employee -> employee.getAge() > 1);
        System.out.println(allMatch);

        //没有匹配
        boolean noneMatch = list.stream().noneMatch(employee -> employee.getAge() > 50);
        System.out.println(noneMatch);

        Optional<Employee> first = list.stream().filter(employee -> employee.getAge() > 30).findFirst();
        

        first.ifPresent(employee -> System.out.println(employee.getLastName() + employee.getFirstName()));
        
        //如果不存在的话返回某个元素
        first.orElseGet(()->list.get(0));
        
        list.stream().findAny().ifPresent(employee -> System.out.println(employee.getFirstName()));
    }
    
    @Test
    public void test1() throws Exception {
        Employee e1 = new Employee("jinlong", "xiao", "M", 35);
        Employee e2 = new Employee("yutong", "xiao", "F", 5);
        Employee e3 = new Employee("lu", "sun", "F", 33);
        Employee e4 = new Employee("xxx", "xiao", "M", 2);
        List<Employee> list = Arrays.asList(e1, e2, e3, e4);

        //Optional<Employee> optional = list.stream().filter(employee -> employee.getAge() > 100).findAny();

        List<String> List = new ArrayList<>();

        boolean b = list.stream().allMatch(str -> str != null);

        System.out.println(b);


    }
    
    
    
    
}
