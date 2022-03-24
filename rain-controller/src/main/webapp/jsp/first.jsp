<%--
  Created by IntelliJ IDEA.
  User: xiao
  Date: 2021/11/29
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>第一个页面</title>
</head>
<body>
<%--    跳转--%>
    <%!
        private int id;
        private String name;
        
        static {
            
        }
        
        public int getNum() {
            return 100;
        }
        
        public class Hello {
            
        }
    %>
    <%
        request.setAttribute("param1", "first里设置的参数值");
    %>
    <jsp:forward page="forwardJsp.jsp">
        <jsp:param name="key" value="xiaojl"/>
    </jsp:forward>
</body>
</html>
