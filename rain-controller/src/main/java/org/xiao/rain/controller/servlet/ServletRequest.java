package org.xiao.rain.controller.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: xiaojl
 * Date: 2021/11/28 16:38
 */
@WebServlet(urlPatterns = "/servletRequest")
public class ServletRequest extends HttpServlet {

    private static final long serialVersionUID = -7132528171549826735L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding(); //设置编码格式
        System.out.println("URI==>" + req.getRequestURI());
        System.out.println("URL==>" + req.getRequestURL());
        System.out.println("请求头:" + req.getHeader("User-Agent"));
        System.out.println("请求方式：" + req.getMethod());
    }
}
