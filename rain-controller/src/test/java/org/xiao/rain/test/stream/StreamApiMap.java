package org.xiao.rain.test.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * Author: xiaojl
 * Date:2022-07-02 10:29
 */
public class StreamApiMap {
    
    @Test
    public void test() {

        Employee e1 = new Employee("jinlong", "xiao", "M", 35);
        Employee e2 = new Employee("yutong", "xiao", "F", 5);
        Employee e3 = new Employee("lu", "sun", "F", 33);
        Employee e4 = new Employee("xxx", "xiao", "M", 2);

        List<Employee> list = Arrays.asList(e1, e2, e3, e4);

        List<String> collect =
                list.stream()
                        .map(employee -> employee.getLastName() + employee.getFirstName())
                        .map(String::toUpperCase)
                        .collect(Collectors.toList());

        System.out.println(collect);

        System.out.println("original List");
        System.out.println(list);


    }
}
