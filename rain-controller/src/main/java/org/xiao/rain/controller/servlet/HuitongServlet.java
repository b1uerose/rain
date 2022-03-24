package org.xiao.rain.controller.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Author: xiaojl
 * Date: 2021/12/16 22:03
 */
@WebServlet(urlPatterns = "/huitong")
public class HuitongServlet extends HttpServlet {

    private static final long serialVersionUID = 5169349592168929913L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("uft-8");
        System.out.println(123);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Authorization = req.getHeader("Authorization");

        System.out.println(Authorization);
    
        req.getParameter("encrypt");
        
        
        String encrypt = getBodyString(req);


        System.out.println(encrypt);
    
    }

    private String getBodyString(HttpServletRequest request) throws ServletException, IOException  {
        StringBuilder sb = new StringBuilder();
        InputStream inputStream = null;
        BufferedReader reader = null;
        try {
            inputStream = request.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {
            }
        }
        return sb.toString();
    }

//    public Object get(HttpServletRequest request) {
//        try {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
//            String body = IOUtils.read(reader);
//            System.out.println("返回json数据");
//            System.out.println(body);
//            System.out.println("结束");
//        }catch (Exception e){
//            System.out.println("错误信息");
//        }
//        return "ok";
//    }
}
