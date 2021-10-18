package org.xiao.rain.service.impl;

import org.springframework.stereotype.Service;
import org.xiao.rain.dao.itf.IRainQueryDao;
import org.xiao.rain.exception.BusinessException;
import org.xiao.rain.service.itf.IRainQueryService;
import org.xiao.rain.vo.user.UserVo;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: xiaojl
 * Date: 2021/7/23 20:27
 */
@Service("queryService")
public class RainQueryServiceImpl implements IRainQueryService {
    
//    @Autowired
//    @Qualifier("queryDao")
    //注入mybatis生成的代理对象
    @Resource(name = "IRainQueryDao")
    private IRainQueryDao dao;
    
    @Override
    public String doSome() throws BusinessException {
        return "dosome";
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

    @Override
    public List<UserVo> queryUserVos() {
        return dao.queryUsersByLike("肖%");
    }

    @Override
    public int insertData() {
        UserVo vo = new UserVo();
        vo.setPk_user("test00002");
        vo.setVusercode("test00002");
        vo.setVusername("test00002");
        vo.setVpassword("test00002");
        return dao.insertUser(vo);
    }
}
