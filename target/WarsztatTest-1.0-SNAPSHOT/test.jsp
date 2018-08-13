<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 12.08.18
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customers</title>
</head>
<body>

<table>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td>${customer}</td>
        </tr>
    </c:forEach>
</table>

<table>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee}</td>
        </tr>
    </c:forEach>
</table>

<table>
    <c:forEach var="vehicle" items="${vehicles}">
        <tr>
            <td>${vehicle}</td>
        </tr>
    </c:forEach>
</table>

<table>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td>${order}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
