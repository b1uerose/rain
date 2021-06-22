package org.xiao.rain.dao.jdbctest;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * 注册驱动的第二种方式
 * Author: xiaojl
 * Date: 2021/6/18 22:52
 */
public class JDBCTest02 {

    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");
        try {
            //1、注册驱动
            Class.forName(driver);
            //2、获取连接 jvm和数据库之间的进程通道，重量级的，一定要关闭
            conn = DriverManager.getConnection(url, user, password);
            //3、获取数据库操作l对象
            statement = conn.createStatement();
            //4、执行sql
            String sql = "select * from bd_user";
            resultSet = statement.executeQuery(sql);
            //5、处理查询结果
            while (resultSet.next()) {
                System.out.println(resultSet.getString("pk_user"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 
     * @param args
     * @throws Exception
     */
    private void test(String[] args) throws Exception {
        
    }
}
