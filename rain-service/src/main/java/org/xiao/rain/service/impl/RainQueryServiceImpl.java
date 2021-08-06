package org.xiao.rain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.xiao.rain.dao.itf.IRainQueryDao;
import org.xiao.rain.exception.BusinessException;
import org.xiao.rain.service.itf.IRainQueryService;

/**
 * Author: xiaojl
 * Date: 2021/7/23 20:27
 */
@Service("queryService")
public class RainQueryServiceImpl implements IRainQueryService {
    
    @Autowired
    @Qualifier("queryDao")
    private IRainQueryDao dao;
    
    @Override
    public String doSome() throws BusinessException {
        return dao.querySomeThing();
    }

    @Override
    public String doOther() {
        return "做了些别的事情！！！！";
    }

    @Override
    public String doAround() {
        return "执行了doAround方法";
    }

    @Override
    public String doException() {
        return "";
    }

    @Override
    public String doAfter() {
        return "" + 100/0;
    }
}
