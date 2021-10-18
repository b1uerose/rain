package org.xiao.rain.test.lambda;

/**
 * 
 * Author: xiaojl
 * Date: 2021/9/13 11:28
 */
public class LambdaPerson {
    
    private String name;
    private int age;

    public LambdaPerson() {
        System.out.println("lambda中的无参构造函数被调用");
    }

    public LambdaPerson(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("lambda中的有参构造函数被调用");
    }

    @Override
    public String toString() {
        return "LambdaPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
