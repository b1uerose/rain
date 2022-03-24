<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: xiao
  Date: 2021/11/30
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:useBean id="userVo" class="org.xiao.rain.vo.user.UserVo" scope="page"/>
    <%
        userVo.setVusercode("xiaojl");
//        out.println(userVo.getVusercode());


        request.setAttribute("emptyNull", null);
        request.setAttribute("emptyStr", "");
        request.setAttribute("emptyArray", new String[]{});
        request.setAttribute("emptyList", new ArrayList<String>());
        request.setAttribute("emptyMap", new HashMap<String, String>());
    %>
    
    ${empty emptyNull}<br>
    ${empty emptyStr}<br>
    ${empty emptyArray}<br>
    ${empty emptyList}<br>
    ${empty emptyMap}<br>
<%--    ${userVo.vusercode}--%>
<%--    ${initParam.corpName}--%>
<%--    ${param.userName}--%>
<%--    ${paramValues.userName[0]}--%>
<%--    ${header.Cookie}--%>

<%--    ${12==12} <br>--%>
<%--    ${12 eq 12} <br>--%>
<%--    ${12 ne 12} <br>--%>
<%--    ${12 lt 12} <br>--%>
<%--    ${12 < 12} <br>--%>
<%--    ${12 >= 12} <br>--%>
<%--    ${12 * 12} <br>--%>
<%--    ${12 >= 12} <br>--%>

</body>
</html>
