package org.xiao.rain.controller.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Author: xiaojl
 * Date: 2021/11/29 23:57
 */
@WebServlet(urlPatterns = "/sessionServlet1")
public class SessionServlet1 extends HttpServlet {

    private static final long serialVersionUID = 5965009494326388021L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("username", "肖金龙");
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("session设置了值");
    }
}
