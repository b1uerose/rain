package org.xiao.rain.controller.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: xiaojl
 * Date: 2021/11/28 10:40
 */
@WebServlet(urlPatterns = "/helloservlet", name = "helloServlet", initParams = {@WebInitParam(name = "username", value = "xiaojl")})
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = -6005618028435709470L;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        //1、获取servlet别名
        System.out.println(config.getServletName());
        
        //2、获取初始化参数 initparam
        System.out.println(config.getInitParameter("username"));
        
        //3、获取servletcontext

        System.out.println(config.getServletContext());
        
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello servlet");

        ServletContext context = getServletConfig().getServletContext();
        //1、获取web.xml中配置的参数
        System.out.println(context.getInitParameter("corpName"));
        
        //2、获取当前工程的上下文路径
        System.out.println(context.getContextPath());
        //3、web工程在服务器硬盘中的绝对路径
        System.out.println(context.getRealPath("/"));
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
    }
}
