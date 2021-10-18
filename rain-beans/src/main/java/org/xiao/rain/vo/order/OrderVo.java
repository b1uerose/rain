package org.xiao.rain.vo.order;

/**
 * Author: xiaojl
 * Date: 2021/8/10 07:01
 */
public class OrderVo {
    
    private Integer pk_order;
    private Integer pk_good;
    private Integer nnum;

    public OrderVo() {
    }

    public OrderVo(Integer pk_order, Integer pk_good, Integer nnum) {
        this.pk_order = pk_order;
        this.pk_good = pk_good;
        this.nnum = nnum;
    }

    public Integer getPk_order() {
        return pk_order;
    }

    public void setPk_order(Integer pk_order) {
        this.pk_order = pk_order;
    }

    public Integer getPk_good() {
        return pk_good;
    }

    public void setPk_good(Integer pk_good) {
        this.pk_good = pk_good;
    }

    public Integer getNnum() {
        return nnum;
    }

    public void setNnum(Integer nnum) {
        this.nnum = nnum;
    }

    @Override
    public String toString() {
        return "OrderVo{" +
                "pk_order=" + pk_order +
                ", pk_good=" + pk_good +
                ", nnum=" + nnum +
                '}';
    }
    
    
}
