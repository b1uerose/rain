package org.xiao.rain.service.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Author: xiaojl
 * Date: 2021/8/3 07:16
 */
public class TestMyBatis {

    public static void main(String[] args) throws Exception {
        //1、获取配置文件
        String configPath = "MyBatis-config.xml";
        //2、转换成inputstram；
        InputStream in = Resources.getResourceAsStream(configPath);
        //3、创建sqlsessionfactorybuilder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4、创建sqlsessionfactory
        SqlSessionFactory factory = builder.build(in);
        //5、从sessionfactory中获取session对象
        SqlSession session = factory.openSession();
        //6、指定要执行sql语句的标志 sql映射文件的namesapce.
        


    }
}
