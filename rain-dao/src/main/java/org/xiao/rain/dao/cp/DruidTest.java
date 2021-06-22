package org.xiao.rain.dao.cp;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Author: xiaojl
 * Date: 2021/6/20 12:21
 */
public class DruidTest {

    public static void main(String[] args) {
        new DruidTest().duridTest();
    }

    public void duridTest() {
        try {
            Properties prop = new Properties();
            InputStream input = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
            prop.load(input);
            DataSource ds = DruidDataSourceFactory.createDataSource(prop);
            Connection conn = ds.getConnection();
            System.out.println(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
