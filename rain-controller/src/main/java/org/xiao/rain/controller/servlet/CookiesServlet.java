package org.xiao.rain.controller.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: xiaojl
 * Date: 2021/11/29 21:53
 */
@WebServlet(urlPatterns = "/cookiesServlet")
public class CookiesServlet extends HttpServlet {


    private static final long serialVersionUID = -2335313847491070145L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Cookie cookie = new Cookie("username", "xiaojl");
        cookie.setMaxAge(1000);
        resp.addCookie(cookie);
        resp.getWriter().write("向客户端办法了一个cookie");
    }
}
