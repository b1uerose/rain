package org.xiao.rain.dao.jdbctest;

import java.sql.*;

/**
 * jdbc测试
 * Author: xiaojl
 * Date: 2021/6/17 23:14
 */
public class JDBCTest {

    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        try {
            //1、注册驱动 告诉jvm要用的是哪个数据库
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            //2、获取连接 jvm和数据库之间的进程通道，重量级的，一定要关闭
            String url = "jdbc:mysql://localhost:3306/rain";
            String user = "root";
            String password = "xiaojl1988";
            conn = DriverManager.getConnection(url, user, password);
            //3、获取执行sql的对象
            statement = conn.createStatement();
            //4、执行sql
            int count = statement.executeUpdate("insert into bd_user (pk_user, vusername, vusercode) values ('xxx', '肖金龙', 'xiaojl')");
//            statement.
            //5、处理结果集(如果是查询的话)
            //6、关闭连接
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6、关闭连接
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
}
