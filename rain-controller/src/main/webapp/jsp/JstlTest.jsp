<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: xiao
  Date: 2021/12/1
  Time: 09:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jstl测试</title>
</head>
<body>
<%--    <%--%>
<%--        session.setAttribute("key", "&lt;&nbsp;hello>");--%>
<%--    %>--%>

<%--    <c:out value="${key}" default="没有找到key的值" escapeXml="false"/>--%>
<%--    <c:out value="${key2}" default="没有找到key2的值" escapeXml="true"/>--%>
<%--    <br>--%>
<%--    <c:set  scope="request" var="key3" value="key3value"/>--%>
<%--    <c:out  value="${key3}" default="undefined" escapeXml="false"/>--%>
<%--    --%>
<%--    <c:set scope="request" var="height" value="180"/>--%>
<%--    <c:if test="${requestScope.height>179}">--%>
<%--        <div>hahaha</div>--%>
<%--    </c:if>--%>

<%--    <c:choose>--%>
<%--        <c:when test="${height > 170}">--%>
<%--            <div>还可以</div>--%>
<%--        </c:when>--%>
<%--        <c:otherwise>--%>
<%--            <div>不太行</div>--%>
<%--        </c:otherwise>--%>
<%--    </c:choose>--%>

    <c:forEach begin="1" end="10" var="i">
        ${i}
    </c:forEach>
<hr>
    <%
        request.setAttribute("array", new String[]{"xiaojl", "sunl", "xiaoyt"});
    %>

    <c:set var="keyxx" value="hello"/>

    <c:forEach items="${array}" var="item">
        ${item}
    </c:forEach>

    

</body>
</html>
