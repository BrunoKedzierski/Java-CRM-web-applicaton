<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 13.08.18
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
</head>
<body>

<div><a href="/admin/employee-add">Dodaj pracownika</a></div>

<table>
    <tr>
        <th>ID</th>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Adres</th>
        <th>Kontakt</th>
        <th>Notatka</th>
        <th>Koszt roboczogodziny</th>
        <th>Akcje</th>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.address}</td>
            <td>${employee.phone}</td>
            <td>${employee.note}</td>
            <td>${employee.manhourValue}</td>
            <td>
                <a href="/admin/employee-edit?id=${employee.id}&name=${employee.name}&surname=${employee.surname}&address=${employee.address}&phone=${employee.phone}&note=${employee.note}&manhourValue=${employee.manhourValue}">Edytuj</a>
                <a href="/admin/employee-del?id=${employee.id}">Usuń</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
