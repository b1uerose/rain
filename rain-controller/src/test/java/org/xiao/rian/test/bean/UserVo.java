package org.xiao.rian.test.bean;

import java.io.Serializable;

/**
 * 用户对象
 * Author: xiaojl
 * Date: 2021/7/4 23:32
 */
public class UserVo implements Serializable {

    private static final long serialVersionUID = 7836040783752552995L;
    
    private int no;
    private String name;

    public UserVo(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
