package org.xiao.rain.framework.processor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 结果集处理结果
 * Author: xiaojl
 * Date: 2021/6/19 15:44
 */
public interface ResultSetProcessor {

    /**
     * 处理结果集并返回需要的数据结构
     * @param rs      数据库结果集
     * @return        结果对象
     */
    public Object handleResultSet(ResultSet rs) throws SQLException;
}
