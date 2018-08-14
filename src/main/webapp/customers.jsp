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
        <c:set var="title" value="Lista klientów"/>
        <c:set var="label" value="Tryb wyświetlania"/>
    </c:if>
    <c:if test="${mode == 'edit'}">
        <c:set var="title" value="Lista klientów (tryb edycji)"/>
        <c:set var="label" value="Tryb edycji"/>
    </c:if>

    <title>${title}</title>
</head>
<body>

<form action="/customer-show" method="post">
    <button type="submit">${label}</button>
</form>

<div>
    <c:if test="${mode == 'edit'}">
        <a href="/customer-add">Dodaj klienta</a>
    </c:if>
</div>

<table>
    <tr>
        <th>ID</th>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Data urodzenia</th>
        <th>Lista samochodów</th>
        <c:if test="${mode == 'edit'}">
            <th>Akcje</th>
        </c:if>
    </tr>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.surname}</td>
            <td>${customer.birthday}</td>
            <td><a href="/vehicle-show?id=${customer.id}">Samochody</a></td>
            <c:if test="${mode == 'edit'}">
                <td>
                    <a href="/customer-edit?id=${customer.id}&name=${customer.name}&surname=${customer.surname}&birthday=${customer.birthday}">Edytuj</a>
                    <a href="/customer-del?id=${customer.id}">Usuń</a>
                </td>
            </c:if>
        </tr>
    </c:forEach>
</table>

</body>
</html>
