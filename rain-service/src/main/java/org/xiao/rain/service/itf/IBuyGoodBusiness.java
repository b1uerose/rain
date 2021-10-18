package org.xiao.rain.service.itf;

import org.xiao.rain.exception.BusinessException;
import org.xiao.rain.vo.good.GoodVo;

/**
 * Author: xiaojl
 * Date: 2021/8/10 07:30
 */
public interface IBuyGoodBusiness {
    
    public void buy(Integer pk_good, int nnum) throws BusinessException;

    public void buy2(Integer pk_good, int nnum) throws BusinessException;

    public GoodVo query_RequiresNew(Integer pk_good) throws BusinessException;
    
    
}
