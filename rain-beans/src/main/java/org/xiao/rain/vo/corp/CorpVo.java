package org.xiao.rain.vo.corp;

import org.springframework.stereotype.Component;

/**
 * 公司
 * Author: xiaojl
 * Date: 2021/7/24 08:07
 */
@Component("myCorp")
public class CorpVo {
    private String pk_corp;
    private String vcode;
    private String vname;
    
    public static final String PK_CORP = "pk_corp";
    public static final String VCODE = "vcode";
    public static final String VNAME = "vname";

    public String getPk_corp() {
        return pk_corp;
    }

    public void setPk_corp(String pk_corp) {
        this.pk_corp = pk_corp;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    @Override
    public String toString() {
        return "CorpVo{" +
                "pk_corp='" + pk_corp + '\'' +
                ", vcode='" + vcode + '\'' +
                ", vname='" + vname + '\'' +
                '}';
    }
}
