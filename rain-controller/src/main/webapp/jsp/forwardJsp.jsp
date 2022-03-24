<%--
  Created by IntelliJ IDEA.
  User: xiao
  Date: 2021/11/29
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>跳转的jsp</title>
</head>
<body>
    <div>别的页面跳转过来，传递的参数为：</div>
<%--    <%--%>
<%--        String param = request.getParameter("key");--%>
<%--        String param1 = (String) request.getAttribute("param1");--%>
<%--        String param2 = (String) pageContext.findAttribute("param1");--%>
<%--        out.println(pageContext.getAttribute("param1", PageContext.REQUEST_SCOPE));--%>
<%--    %>--%>
<%--    <div><%=param%></div>--%>
<%--    <div><%=param1%></div>--%>
<%--    <div><%=param2%></div>--%>
    
    <%=request.getParameter("")%>
    ${param1}
</body>
</html>
