package org.xiao.rain.dao.jdbctest;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * preparedstatment sql预编译
 * Author: xiaojl
 * Date: 2021/6/19 18:21
 */
public class JDBCTest03 {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            String sql = "select * from bd_user where vusercode = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "xiaojl");
            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("存在记录");
            } else {
                String insertSql = "insert into bd_user (pk_user,vusercode,vusername,vpassword) values(?,?,?,?)";
                ps = conn.prepareStatement(insertSql);
                ps.clearParameters();
                ps.setString(1, "pk");
                ps.setString(2, "xiaojl");
                ps.setString(3, "肖金龙");
                ps.setString(4, "xiaojl1988");
                ps.executeUpdate();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }


    }
}
