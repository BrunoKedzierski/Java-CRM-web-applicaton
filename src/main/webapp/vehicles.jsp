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
    <c:if test="${mode == 'show'}">
        <c:set var="title" value="Lista samochodów"/>
        <c:set var="label" value="Tryb wyświetlania"/>
    </c:if>
    <c:if test="${mode == 'edit'}">
        <c:set var="title" value="Lista samochodów (tryb edycji)"/>
        <c:set var="label" value="Tryb edycji"/>
    </c:if>

    <title>${title}</title>
</head>
<body>

<form action="/admin/vehicle-show" method="post">
    <button type="submit">${label}</button>
</form>

<div>
    <c:if test="${mode == 'edit'}">
        <a href="/admin/vehicle-add">Dodaj samochód</a>
    </c:if>
</div>

<table>
    <tr>
        <th>ID</th>
        <th>Model</th>
        <th>Marka</th>
        <th>Rok produkcji</th>
        <th>Następny przegląd</th>
        <th>Właściciel</th>
        <c:if test="${mode == 'edit'}">
            <th>Akcje</th>
        </c:if>

    </tr>
    <c:forEach var="vehicle" items="${vehicles}">
        <tr>
            <td>${vehicle.id}</td>
            <td>${vehicle.model}</td>
            <td>${vehicle.brand}</td>
            <td>${vehicle.productionYear}</td>
            <td>${vehicle.nextCheckup}</td>
            <td>
                <a href="/admin/customer-show?id=${vehicle.owner.id}">${vehicle.owner.name} ${vehicle.owner.surname}</a>
            </td>
            <c:if test="${mode == 'edit'}">
                <td>
                        <%--<a href="/vehicle-edit?id=${customer.id}&name=${customer.name}&surname=${customer.surname}&birthday=${customer.birthday}">Edytuj</a>--%>
                        <a href="/admin/vehicle-del?id=${vehicle.id}">Usuń</a>
                </td>
            </c:if>
        </tr>
    </c:forEach>
</table>

</body>
</html>
