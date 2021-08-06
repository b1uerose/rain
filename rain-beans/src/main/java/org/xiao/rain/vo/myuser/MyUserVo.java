package org.xiao.rain.vo.myuser;

/**
 * Author: xiaojl
 * Date: 2021/8/5 13:18
 */
public class MyUserVo {
    
    private String pk;
    private String vname;
    private String vcode;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
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

    @Override
    public String toString() {
        return "MyUserVo{" +
                "pk='" + pk + '\'' +
                ", vname='" + vname + '\'' +
                ", vcode='" + vcode + '\'' +
                '}';
    }
}
