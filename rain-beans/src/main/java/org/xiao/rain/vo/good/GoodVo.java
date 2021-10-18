package org.xiao.rain.vo.good;

/**
 * Author: xiaojl
 * Date: 2021/8/10 07:04
 */
public class GoodVo {
    
    private Integer pk_good;
    private String vname;
    private Integer nnum;
    private Float nprice;

    public GoodVo() {
    }

    public GoodVo(Integer pk_good, String vname, Integer nnum, Float nprice) {
        this.pk_good = pk_good;
        this.vname = vname;
        this.nnum = nnum;
        this.nprice = nprice;
    }

    public Integer getPk_good() {
        return pk_good;
    }

    public void setPk_good(Integer pk_good) {
        this.pk_good = pk_good;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public Integer getNnum() {
        return nnum;
    }

    public void setNnum(Integer nnum) {
        this.nnum = nnum;
    }

    public Float getNprice() {
        return nprice;
    }

    public void setNprice(Float nprice) {
        this.nprice = nprice;
    }

    @Override
    public String toString() {
        return "GoodVo{" +
                "pk_good=" + pk_good +
                ", vname='" + vname + '\'' +
                ", nnum=" + nnum +
                ", nprice=" + nprice +
                '}';
    }
}
