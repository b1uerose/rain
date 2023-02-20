package org.xiao.rain.test.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * stream 测试
 * Author: xiaojl
 * Date:2022-07-02 10:02
 */
@Data
@AllArgsConstructor
public class Employee {
    private String firstName;
    private String lastName;
    private String sex;
    private int age;
    
}
