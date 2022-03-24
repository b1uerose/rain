package org.xiao.rain.controller.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: xiaojl
 * Date: 2021/11/28 23:35
 */
@WebServlet(urlPatterns = "/refreshServlet")
public class RefreshServlet extends HttpServlet {
    private static final long serialVersionUID = -1558958262255213724L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //3秒后跳转
        resp.setHeader("Refresh", "3;url='/rain/index.jsp'");
        //3秒刷新一次
//        resp.setHeader("Refresh", "3");
        Date current = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:sss SSS");
        resp.getWriter().write("currentTime is : " + sdf.format(current));
    }
}
