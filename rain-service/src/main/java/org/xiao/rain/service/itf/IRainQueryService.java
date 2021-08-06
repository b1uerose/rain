package org.xiao.rain.service.itf;

import org.xiao.rain.exception.BusinessException;

/**
 * 查询服务
 * Author: xiaojl
 * Date: 2021/7/23 20:26
 */
public interface IRainQueryService {
    
    public String doSome() throws BusinessException;
    
    public String doOther();
    
    public String doAround();
    
    public String doException();
    
    public String doAfter();
    
    
}
