package org.xiao.rain.controller.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: xiaojl
 * Date: 2021/11/28 17:16
 */
@WebServlet(urlPatterns = "/servlet1")
public class Servlet1 extends HttpServlet  {
    private static final long serialVersionUID = -2430815280319877775L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        req.setAttribute("key", "servlet1处理过的数据");
        //转发到servlet2
        RequestDispatcher dispatcher = req.getRequestDispatcher("/servlet2");
        dispatcher.forward(req, resp);


    }
}
