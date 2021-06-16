package org.xiao.rain.controller.servlet;

import org.xiao.rain.service.test.TestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 测试servlet
 * Author: xiaojl
 * Date: 2021/6/14 14:56
 */
@WebServlet(urlPatterns = "/user")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("test servlet");
        
        TestService.testService();
        
    }

}
