package org.xiao.rain.test.type;

import java.util.Iterator;
import java.util.Random;

/**
 * Author: xiaojl
 * Date: 2021/7/20 00:16
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator(3);
        for(Coffee c : gen) {
            System.out.println(c);
        }
    }
    
    private Class[] types = new Class[]{Latte.class, Cappuccino.class, Mocha.class};
    private static Random rand = new Random(47);
    private int size;

    public CoffeeGenerator() {
    }

    public CoffeeGenerator(int size) {
        this.size = size;
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new Iterator<Coffee>() {
            int count = size;
            @Override
            public boolean hasNext() {
                return count>0;
            }

            @Override
            public Coffee next() {
                count--;
                return CoffeeGenerator.this.next();
            }
        };
    }
}
