package org.xiao.rain.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.xiao.rain.dao.BaseDao;
import org.xiao.rain.dao.itf.IRainQueryDao;
import org.xiao.rain.vo.myuser.MyUserVo;
import org.xiao.rain.vo.queryparam.QueryParam;
import org.xiao.rain.vo.user.UserVo;

import java.util.List;
import java.util.Map;

/**
 * IRainQueryDao 实现类
 * Author: xiaojl
 * Date: 2021/7/24 15:33
 */
@Repository("queryDao")
public class RainQueryDaoImpl implements IRainQueryDao {
    @Override
    public String querySomeThing() {
        return "fetch something";
    }

    @Override
    public List<UserVo> queryUserVos() {
        SqlSession session = BaseDao.getInstance().getSqlSession();
        String sqlId = "org.xiao.rain.dao.itf.IRainQueryDao.queryUserVos";
        List<UserVo> userVos = session.selectList(sqlId);
        session.close();
        return userVos;
    }

    @Override
    public int insertUser(UserVo user) {
        return 0;
    }

    @Override
    public UserVo queryUserByUserName(String vuseranme) {
        return null;
    }

    @Override
    public List<UserVo> queryUserVosByMultiParams(String vusername, String vusercode) {
        return null;
    }

    @Override
    public List<UserVo> queryUserVosByQueryParams(QueryParam param) {
        return null;
    }

    @Override
    public List<UserVo> queryUserVosByArg(String vusercode, String vusername) {
        return null;
    }

    @Override
    public List<UserVo> queryUsersByMap(Map<String, Object> map) {
        return null;
    }

    @Override
    public List<Map<String, Object>> queryUserResultTypeIsMap(String vusername) {
        return null;
    }

    @Override
    public List<UserVo> queryUsersByResultMap(String vusername) {
        return null;
    }

    @Override
    public List<MyUserVo> queryUsersByDiffColumnName() {
        return null;
    }

    @Override
    public List<UserVo> queryUsersByLike(String likeusername) {
        return null;
    }

    @Override
    public List<UserVo> queryUsersByIf(UserVo vo) {
        return null;
    }

    @Override
    public List<UserVo> queryUserByWhereCond(UserVo vo) {
        return null;
    }
}
