package org.xiao.rain.dao.test;

import org.xiao.rain.dao.impl.RainQueryDaoImpl;
import org.xiao.rain.dao.itf.IRainQueryDao;
import org.xiao.rain.vo.user.UserVo;

import java.util.List;

/**
 * Author: xiaojl
 * Date: 2021/8/3 07:16
 */
public class TestMyBatis {

    public static void main(String[] args) throws Exception {
//        //1、获取配置文件
//        String configPath = "MyBatis-config.xml";
//        //2、转换成inputstram；
//        InputStream in = Resources.getResourceAsStream(configPath);
//        //3、创建sqlsessionfactorybuilder
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        //4、创建sqlsessionfactory
//        SqlSessionFactory factory = builder.build(in);
//        //5、从sessionfactory中获取session对象
//        SqlSession session = factory.openSession();
//        //6、指定要执行sql语句的标志 sql映射文件的namesapce.sql标签的id
//        String sqlId = "org.xiao.rain.dao.itf.IRainQueryDao" + "." + "queryUserVos";
//        //7、session执行sql
//        List<UserVo> users = session.selectList(sqlId);
//        for (UserVo user : users) {
//            System.out.println(user);
//        }
//        //8、关闭sqlsession
//        session.close();
//
//
//        UserVo user = new UserVo();
//        user.setPk_user("1113");
//        user.setVusername("xiaoxx");
//        user.setVusercode("xiaoxx");
//        user.setVpassword("123");
//        List<UserVo> list1 = new ArrayList<UserVo>();
//        list1.add(user);
//        String sqlid = "org.xiao.rain.dao.itf.IRainQueryDao.insertUser";
//        BaseDao.getInstance().getSqlSession();

        IRainQueryDao dao = new RainQueryDaoImpl();
        List<UserVo> userVos = dao.queryUserVos();

        for (UserVo userVo : userVos) {
            System.out.println(userVo);
        }

    }
}
