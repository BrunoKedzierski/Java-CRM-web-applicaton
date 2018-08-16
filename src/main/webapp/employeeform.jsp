<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 13.08.18
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <c:if test="${mode == 'add'}">
        <c:set var="title" value="Dodawanie pracownika"/>
        <c:set var="target" value="/admin/employee-add"/>
    </c:if>
    <c:if test="${mode == 'edit'}">
        <c:set var="title" value="Edycja pracownika"/>
        <c:set var="target" value="/admin/employee-edit"/>
    </c:if>

    <title>${title}</title>


</head>
<body>
<form action="${target}" method="post">
    <label>
        Imię
        <input type="text" name="name" value="${not empty name ? name : ""}" placeholder="Podaj imię pracownika">
    </label><br>
    <label>
        Nazwisko
        <input type="text" name="surname" value="${not empty surname ? surname : ""}" placeholder="Podaj nazwisko pracownika">
    </label><br>
    <label>
        Adres
        <input type="text" name="address" value="${not empty address ? address : ""}" placeholder="Podaj adres pracownika">
    </label><br>
    <label>
        Kontakt
        <input type="text" name="phone" value="${not empty phone ? phone : ""}" placeholder="Podaj numer telefonu">
    </label><br>
    <label>
        Notatka
        <input type="text" name="note" value="${not empty note ? note : ""}" placeholder="Wprowadź notatkę">
    </label><br>
    <label>
        Koszt roboczogodziny
        <input type="numer" step="0.01" min="0.01" name="manhourValue" value="${not empty manhourValue ? manhourValue : ""}" placeholder="Podaj koszt roboczogodziny">
    </label><br>
    <input type="submit" value="Zapisz">
</form>

</body>
</html>
