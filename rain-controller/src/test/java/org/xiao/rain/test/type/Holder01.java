package org.xiao.rain.test.type;

/**
 * Author: xiaojl
 * Date: 2021/7/1 23:39
 */
public class Holder01<T> {
    
    private T a;

    public Holder01(T a) {
        this.a = a;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }
    
    public <U> U getValue(U obj) {
        return  obj;
    }
    

    public static void main(String[] args) {
        Holder01<String>  holder = new Holder01<String>("123");
        System.out.println(holder.getA());
        holder.setA("321");
        
        Holder01<Integer> holder02 = new Holder01<Integer>(12);
    }
}
