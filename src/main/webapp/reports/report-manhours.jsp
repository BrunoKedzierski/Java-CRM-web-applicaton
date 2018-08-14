<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 14.08.18
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Raport roboczogodzin</title>
</head>
<body>

<form action="/report-manhours" method="get">
    <label>
        Data od
        <input type="date" name="from" value="${not empty from ? from : ""}">
    </label>
    <label>
        do
        <input type="date" name="to" value="${not empty to ? to : ""}">
    </label>
    <input type="submit" value="Wyświetl">
</form>

<table>
    <tr>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Przepracowane godziny</th>
    </tr>

    <c:forEach var="line" items="${report}">
        <tr>
            <td>${line[0]}</td>
            <td>${line[1]}</td>
            <td>${line[2]}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
