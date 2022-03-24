package org.xiao.rain.controller.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: xiaojl
 * Date: 2021/11/30 00:14
 */
@WebServlet(urlPatterns = "/sessionServlet3")
public class SessionServlet3 extends HttpServlet {
    private static final long serialVersionUID = 5215944994959239491L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.sendRedirect(resp.encodeURL("/rain/sessionServlet2"));
    }
}
