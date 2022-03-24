package org.xiao.rain.controller.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向1
 * Author: xiaojl
 * Date: 2021/11/28 21:17
 */
@WebServlet(urlPatterns = "/response1")
public class Response1 extends HttpServlet {

    private static final long serialVersionUID = -4831755662664933046L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("response1 到此一游");
        
//        resp.setStatus(302);
//        
//        resp.setHeader("Location", "/rain/response2");
        resp.sendRedirect("/rain/response2");
    }
}
