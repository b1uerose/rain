package org.xiao.rain.controller.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 获取request中所有的
 * Author: xiaojl
 * Date: 2021/11/29 09:36
 */
public class GetAllParameterServlet extends HttpServlet {

    private static final long serialVersionUID = -4087832264991997225L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String key = parameterNames.nextElement();
            String value = req.getParameter(key);
        }
    }
}
