package org.xiao.rain.dao.jdbctest;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * jdbc事务的测试
 * Author: xiaojl
 * Date: 2021/6/19 20:56
 */
public class JDBCTest05 {

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
            conn.getTransactionIsolation();
            //不自动提交
            conn.setAutoCommit(false);
            String sql = "update bd_user set vdef1 = ? where vusercode = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "xiaojl");
            ps.setString(2, "xiaojl");
            int count = ps.executeUpdate();
            System.out.println(count);
//            String s = null;
//            s.toString();
            
            ps.clearParameters();
            ps.setString(1, "sunl");
            ps.setString(2, "sunl");
            count += ps.executeUpdate();
            conn.commit();
        } catch (Exception e) {
//            if(conn != null) {
//                try {
//                    conn.rollback();
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
//            }
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
