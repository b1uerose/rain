package org.xiao.rain.test.type;

/**
 * Author: xiaojl
 * Date: 2021/6/26 15:55
 */
public class Son extends Parent {
    private Integer id;
    
    {
        System.out.println("3、子类被初始化了");
    }
    
    static {
        System.out.println("子类被加载了");
    }

    @Override
    public void doSome() {
        System.out.println("子类做些事情把");
    }

    public Son() {
        System.out.println("子类的默认构造函数被调用了");
    }
    
    public Son(int id, String name) {
        super(id, name);
        System.out.println("子类的带参数的构造函数被调用了");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
