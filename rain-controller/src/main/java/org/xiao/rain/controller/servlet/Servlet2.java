package org.xiao.rain.controller.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet2
 * Author: xiaojl
 * Date: 2021/11/28 17:17
 */
@WebServlet(urlPatterns = "/servlet2")
public class Servlet2 extends HttpServlet {

    private static final long serialVersionUID = 8084141072399166362L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String userName = req.getParameter("userName");
        System.out.println("userName : " + userName);
        String value = (String) req.getAttribute("key");
        System.out.println(value);
        
    }
}
