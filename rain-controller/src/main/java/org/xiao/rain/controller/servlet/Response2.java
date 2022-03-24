package org.xiao.rain.controller.servlet;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 重定向
 * Author: xiaojl
 * Date: 2021/11/28 21:17
 */
@WebServlet(urlPatterns = "/response2")
public class Response2 extends HttpServlet {
    
    private static final long serialVersionUID = -6826599443604665026L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //第一种设置编码格式
//        resp.setCharacterEncoding("utf-8");
//        resp.setHeader("Content-Type", "text/html;charset=utf-8");
        //第二种设置编码格式
        resp.setContentType("text/html;charset=utf-8");

        Cookie[] cookies = req.getCookies();

        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName());
            System.out.println(cookie.getValue());
        }

        List<String> list = new ArrayList<String>();
        resp.getWriter().write("response2 处理请求");
        
        
        String[] ar = new String[]{"1","2"};

        Array.newInstance(ar.getClass().getComponentType(), 10);
        
        
        
        
        
    }
    
}
