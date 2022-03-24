package org.xiao.rain.controller.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * Author: xiaojl
 * Date: 2021/11/28 23:24
 */
@WebServlet(urlPatterns = "/downloadServlet")
public class DownloadServlet extends HttpServlet {
    private static final long serialVersionUID = -1784477228165239059L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream stream = getServletContext().getResourceAsStream("/images/奔跑的北极熊.png");
        ServletOutputStream outputStream = resp.getOutputStream();
        resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("奔跑的北极熊", "utf-8"));
        byte[] bytes = new byte[1024];
        int length = 0;
        while ((length = stream.read(bytes)) > 0) {
            outputStream.write(bytes, 0, length);
        }
        outputStream.close();
        stream.close();
    }
}
