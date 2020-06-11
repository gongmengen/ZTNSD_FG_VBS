<%--
  Created by IntelliJ IDEA.
  User: msi-
  Date: 2020/1/19
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>

        <th>收录时间</th>

        <th><input type="checkbox" id="checkbox"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${informationList}" var="websiteList">
        <tr>
            <td><fmt:parseDate value="${websiteList.createtime}" pattern="yyyy-MM-dd HH:mm" var="masterDate"/><fmt:formatDate value="${masterDate}" pattern="yyyy-MM-dd HH:mm" ></fmt:formatDate></td>
        </tr>

    </c:forEach>
    </tbody>
</table>
</body>
</html>
