package org.xiao.rain.test.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Test;
import org.xiao.rain.exception.BusinessException;

/**
 * 谓词逻辑
 * Author: xiaojl
 * Date:2022-07-02 10:29
 */
public class StreamApiFilter {

    @Test
    public void test3() throws BusinessException {

        Employee e1 = new Employee("jinlong", "xiao", "M", 35);
        Employee e2 = new Employee("yutong", "xiao", "F", 5);
        Employee e3 = new Employee("lu", "sun", "F", 33);
        Employee e4 = new Employee("xxx", "xiao", "M", 2);

        List<Employee> list = Arrays.asList(e1, e2, e3, e4);

        List<Employee> employees = list.stream()
                .filter(ageGreaterThan30.and(genderIsFemale).negate())
                //.filter(ageGreaterThan30.and(genderIsFemale).or(genderIsFemale).negate())
                .collect(Collectors.toList());

        System.out.println(employees);
    }

    public Predicate<Employee> ageGreaterThan30 = employee -> employee.getAge() > 30;
    public Predicate<Employee> genderIsFemale = employee -> employee.getSex().equals("F");
}
