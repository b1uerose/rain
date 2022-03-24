<%--
  Created by IntelliJ IDEA.
  User: xiao
  Date: 2021/11/30
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>scope2</title>
</head>
<body>
    pageContext的域对象中的只:<%=pageContext.getAttribute("key")%> <br>
    request的域对象中的只:<%=request.getAttribute("key")%> <br>
    session的域对象中的只:<%=session.getAttribute("key")%> <br>
    application的域对象中的只:<%=application.getAttribute("key")%> <br>
</body>
</html>
