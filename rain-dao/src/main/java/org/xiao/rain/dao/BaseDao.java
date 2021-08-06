package org.xiao.rain.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Author: xiaojl
 * Date: 2021/8/3 12:21
 */
public class BaseDao {
    
    private BaseDao() {}

    private final static BaseDao m_instance;
    
    private static SqlSessionFactory factory = null;
    
    static {
        m_instance = new BaseDao();
        InputStream in = null;
        try {
            //1、主配置文件
            String configPath = "MyBatis-config.xml";
            //2、主配置文件转成输入流
            in = Resources.getResourceAsStream(configPath);
            //3、构造builder
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //4、获得factory
            factory = builder.build(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static BaseDao getInstance() {
        return m_instance;
    }
    
    public SqlSession getSqlSession() {
        return factory.openSession();
    }
    
    public <T> List<T> retrieveAll(T clazz, String sqlId) throws Exception {
        //1、主配置文件
        String configPath = "MyBatis-config.xml";
        //2、主配置文件转成输入流
        InputStream in = Resources.getResourceAsStream(configPath);
        //3、构造builder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4、获得factory
        SqlSessionFactory factory = builder.build(in);
        //5、构造session
        SqlSession session = factory.openSession();
        //6、执行sql
        List<T> resultList = session.selectList(sqlId);
        //7、关闭session
        session.close();
        return resultList;
    }
    
    public <T> int insertBean(T bean, String sqlId) throws Exception {
        //1、主配置文件
        String configPath = "MyBatis-config.xml";
        //2、主配置文件转成输入流
        InputStream in = Resources.getResourceAsStream(configPath);
        //3、构造builder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4、获得factory
        SqlSessionFactory factory = builder.build(in);
        //5、构造session
        SqlSession session = factory.openSession();
        //6、插入数据
        int count = session.insert(sqlId, bean);
        //7、提交事务
        session.commit();
        //8、关闭session
        session.close();
        return count;
    }
    
    
    
}
