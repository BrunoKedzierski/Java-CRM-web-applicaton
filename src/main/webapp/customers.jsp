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
    <title>Lista klientów</title>
</head>
<body>

<div><a href="/customer-add">Dodaj klienta</a></div>

<table>
    <tr>
        <th>ID</th>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Data urodzenia</th>
        <th>Akcje</th>
    </tr>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.surname}</td>
            <td>${customer.birthday}</td>
            <td>
                <a href="/customer-edit?id=${customer.id}&name=${customer.name}&surname=${customer.surname}&birthday=${customer.birthday}">Edytuj</a>
                <a href="/customer-del?id=${customer.id}">Usuń</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
