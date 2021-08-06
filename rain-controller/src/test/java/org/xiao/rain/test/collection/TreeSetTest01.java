package org.xiao.rain.test.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Author: xiaojl
 * Date: 2021/7/3 22:06
 */
public class TreeSetTest01 {

    public static void main(String[] args) {
        Set<Person> set = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });
        set.add(new Person(10));
        set.add(new Person(20));
        set.add(new Person(30));
        set.add(new Person(21));
        set.add(new Person(22));
        set.add(new Person(33));
        
        //创建集合的迭代器
        Iterator<Person> iterator = set.iterator();
        while (iterator.hasNext()) {
            Person person =  iterator.next();
            System.out.println(person);
        }
    }
}

class Person{

    int age;

    public Person(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}
//class Person implements Comparable<Person> {
//
//    int age;
//
//    public Person(int age) {
//        this.age = age;
//    }
//
//    @Override
//    public int compareTo(Person o) {
//        return this.age - o.age;
//    }
//
//    @Override
//    public String toString() {
//        return "Person{" +
//                "age=" + age +
//                '}';
//    }
//}
