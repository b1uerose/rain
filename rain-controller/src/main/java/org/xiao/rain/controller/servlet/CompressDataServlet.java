package org.xiao.rain.controller.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: xiaojl
 * Date: 2021/11/28 23:46
 */
@WebServlet(urlPatterns = "/compressDataServlet")
public class CompressDataServlet extends HttpServlet {
    private static final long serialVersionUID = -7345283931979443754L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        resp.setHeader("Content-Encoding", "gzip");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);

        String ss = "fsdfhsdfhuisdhfusdhfuids" +
                "fsdfdsfsdfsdfdsfdafdsfhsdjfhsdjkfhkjds" +
                "fdsfjdslkfjsldkfjsdlkfjsdkfsdjkff" +
                "fsjdfjdsklfjdsklfjkldsfjlksdjflksdjflkds" +
                "dsjfklsdjflsdjfkldsfkjsdkfjsldkfjsdlfk" +
                "fdsjlkfjdslkfjsdlkfjlkasjflk";
        gzipOutputStream.write(ss.getBytes());
        gzipOutputStream.close();
        resp.getOutputStream().write(byteArrayOutputStream.toByteArray());
        byteArrayOutputStream.close();
    }
}
