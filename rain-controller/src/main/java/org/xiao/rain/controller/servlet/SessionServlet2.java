package org.xiao.rain.controller.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: xiaojl
 * Date: 2021/11/30 00:00
 */
@WebServlet(urlPatterns = "/sessionServlet2")
public class SessionServlet2 extends HttpServlet {

    private static final long serialVersionUID = 6858466317039109576L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getSession().getAttribute("username"));
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("获取用户名：" + req.getSession().getAttribute("username"));
    }
}
