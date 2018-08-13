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
    <title>From</title>
</head>
<body>
<form action="" method="post">
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
        <input type="date" name="birthday" value="${not empty birthday ? birthday : ""}"
               placeholder="Podaj datę urodzenia">
    </label><br>
    <input type="submit" value="Zapisz">
</form>
</body>
</html>
