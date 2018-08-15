<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 13.08.18
  Time: 09:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Warsztat samochodowy</title>
</head>
<body>
<jsp:include page="WEB-INF/fragments/header.jsp"/>

<c:if test="${not empty sessionScope.username}">
    Zalogowany jako ${sessionScope.username}
    <a href="/admin/logout">Wyloguj</a>
</c:if>
<c:if test="${empty sessionScope.username}">
    Niezalogowany
    <a href="/login">Zaloguj</a>
</c:if>

<br><br>

<a href="/admin/customer-show">Klienci</a><br>
<a href="/admin/vehicle-show">Samochody</a><br>
<a href="/admin/employee-show">Pracownicy</a><br>

<br><br>
<a href="/admin/reports">Raporty</a><br>


<jsp:include page="WEB-INF/fragments/footer.jsp"/>
</body>
</html>
