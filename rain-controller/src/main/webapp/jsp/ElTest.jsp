<%--
  Created by IntelliJ IDEA.
  User: xiao
  Date: 2021/12/1
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式</title>
</head>
<body>
    <jsp:useBean id="userVo" class="org.xiao.rain.vo.user.UserVo"/>
        
    <%
        session.setAttribute("key1", "value");
    
    %>


    1、协议：${pageContext.request.scheme}<br>
    2、sessionid：${pageContext.session.id}<br>
    3、请求方式：${pageContext.request.method}<br>
    4、服务器ip：${pageContext.request.serverName}<br>
    5、服务器端口：${pageContext.request.serverPort}<br>
    6、工程路径：${pageContext.request.contextPath}<br>
    7、资源路径：${pageContext.servletContext.getRealPath("/")}<br>
    8、${pageContext.servletConfig.servletName}<br>
    9、${pageContext.servletContext.getInitParameter("corpName")}<br> br
</body>
</html>
