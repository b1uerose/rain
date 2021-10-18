package org.xiao.rain.test.thread.atomic;

/**
 * Author: xiaojl
 * Date: 2021/9/27 12:42
 */
public class AtomicTestJavaBean {
    
    private String vname;
    private String vcode;
    private int age;

    public AtomicTestJavaBean(String vname, String vcode, int age) {
        this.vname = vname;
        this.vcode = vcode;
        this.age = age;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
