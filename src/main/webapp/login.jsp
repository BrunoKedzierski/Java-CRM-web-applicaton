<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 15.08.18
  Time: 09:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logowanie</title>
</head>
<body>

<form action="/login" method="post">
    <label>
        Login
        <input type="text" name="login">
    </label><br>
    <label>
        password
        <input type="text" name="password">
    </label><br>

    <input type="submit">
</form>

</body>
</html>
