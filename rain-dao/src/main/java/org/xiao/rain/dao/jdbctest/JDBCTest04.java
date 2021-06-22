package org.xiao.rain.dao.jdbctest;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * preparedstatment sql预编译
 * Author: xiaojl
 * Date: 2021/6/19 18:21
 */
public class JDBCTest04 {

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
            conn.setAutoCommit(false);
            String sql = "select * from bd_user where vusercode like ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "_iaoj%");
            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("存在记录");
            }
            conn.commit();
        } catch (Exception e) {
            if(conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        }  finally {
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
