package org.xiao.rain.test.type;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: xiaojl
 * Date: 2021/7/2 07:53
 */
public class Holder<A,B> {
    
    public final A a;
    public final B b;

    public Holder(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        Holder<String, List<String>> holder = new Holder<String, List<String>>("avc", new ArrayList<String>());
    }
}
