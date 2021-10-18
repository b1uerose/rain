package org.xiao.rain.dao.itf;

import org.apache.ibatis.annotations.Param;
import org.xiao.rain.vo.myuser.MyUserVo;
import org.xiao.rain.vo.queryparam.QueryParam;
import org.xiao.rain.vo.user.UserVo;

import java.util.List;
import java.util.Map;

/**
 * Author: xiaojl
 * Date: 2021/7/24 15:32
 */
public interface IRainQueryDao {
    
    public String querySomeThing();

    /**
     * 查询全部
     * @return
     */
    public List<UserVo> queryUserVos();

    /**
     * 插入数据
     * @param user
     * @return
     */
    public int insertUser(UserVo user);

    /**
     * mybatis一个简单类型
     * 返回值只有一个，如果查询出来多个会报错
     * @param vuseranme
     * @return
     */
    public UserVo queryUserByUserName(String vuseranme);

    /**
     * 使用多个参数类型来查
     * @param vusername
     * @param vusercode
     * @return
     */
    public List<UserVo> queryUserVosByMultiParams(@Param("name") String vusername, @Param("code") String vusercode);

    /**
     * 使用参数对象来查
     * @param param
     * @return
     */
    public List<UserVo> queryUserVosByQueryParams(QueryParam param);

    /**
     * 多个参数-位置
     * @param vusercode
     * @param vusername
     * @return
     */
    public List<UserVo> queryUserVosByArg(String vusercode, String vusername);

    /**
     * 多个参数-按map来取
     * @param map
     * @return
     */
    public List<UserVo> queryUsersByMap(Map<String, Object> map);

    /**
     * 查询
     * @return
     */
    public List<Map<String, Object>> queryUserResultTypeIsMap(@Param("name") String vusername);

    /**
     * mybatis的配置resultmap
     * @param vusername
     * @return
     */
    public List<UserVo> queryUsersByResultMap(@Param("vusername") String vusername);
    
    
    public List<MyUserVo> queryUsersByDiffColumnName();
    
    public List<UserVo> queryUsersByLike(@Param("likeusername") String likeusername);

    /**
     * 动态sql if
     * @param vo
     * @return
     */
    public List<UserVo> queryUsersByIf(UserVo vo);

    /**
     * 动态sql where
     * @param vo
     * @return
     */
    public List<UserVo> queryUserByWhereCond(UserVo vo);

    /**
     * mybatis 动态生成in
     * @param userNameList
     * @return
     */
    public List<UserVo> queryUsersByList(List<String> userNameList);
    
}
