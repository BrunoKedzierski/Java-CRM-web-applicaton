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
        <c:set var="title" value="Dodawanie samochodu"/>
        <c:set var="target" value="/vehicle-add"/>
    </c:if>
    <c:if test="${mode == 'edit'}">
        <c:set var="title" value="Edycja samochodu"/>
        <c:set var="target" value="/vehicle-edit"/>
    </c:if>

    <title>${title}</title>
</head>
<body>

<%--private int id;--%>
<%--private String model;--%>
<%--private String brand;--%>
<%--private int productionYear;--%>
<%--private LocalDate nextCheckup;--%>
<%--private Customer owner;--%>

<form action="${target}" method="post">
    <label>
        Model
        <input type="text" name="model" value="${not empty model ? model : ""}" placeholder="Podaj imię">
    </label><br>
    <label>
        Marka
        <input type="text" name="brand" value="${not empty brand ? brand : ""}" placeholder="Podaj nazwisko">
    </label><br>
    <label>
        Rok produkcji
        <input type="number" name="productionYear" value="${not empty productionYear ? productionYear : ""}">
    </label><br>
    <label>
        Następny przegląd
        <input type="date" name="nextCheckup" value="${not empty nextCheckup ? nextCheckup : ""}">
    </label><br>
    <label>
        Właściciel
        <%--<input type="date" name="owner" value="${not empty owner ? owner : ""}">--%>
    </label><br>
    <input type="submit" value="Zapisz">
</form>

</body>
</html>
