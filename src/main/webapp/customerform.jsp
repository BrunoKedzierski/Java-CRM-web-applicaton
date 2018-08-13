<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 13.08.18
  Time: 09:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:if test="${mode == 'add'}">
        <c:set var="title" value="Dodawanie klienat"/>
        <c:set var="target" value="/customer-add"/>
    </c:if>
    <c:if test="${mode == 'edit'}">
        <c:set var="title" value="Edycja klienta"/>
        <c:set var="target" value="/customer-edit"/>
    </c:if>

    <title>${title}</title>
</head>
<body>

<form action="${target}" method="post">
    <label>
        Imię
        <input type="text" name="name" value="${not empty name ? name : ""}" placeholder="Podaj imię">
    </label><br>
    <label>
        Nazwisko
        <input type="text" name="surname" value="${not empty surname ? surname : ""}" placeholder="Podaj nazwisko">
    </label><br>
    <label>
        Data urodzenia
        <input type="date" name="birthday" value="${not empty birthday ? birthday : ""}">
    </label><br>
    <input type="submit" value="Zapisz">
</form>

</body>
</html>
