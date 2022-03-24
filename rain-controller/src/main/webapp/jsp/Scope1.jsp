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
    <title>scope1</title>
</head>
<body>

    <%
        pageContext.setAttribute("key", "pageContext");
        request.setAttribute("key", "request");
        session.setAttribute("key", "session");
        application.setAttribute("key", "application");
    %>

    <jsp:forward page="Scope2.jsp"/>
    
</body>
</html>
