<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <p>Deine IP ist ${ip}, und du verwendest ${browser}.</p>
    <form action="./" method="POST">
        <c:forEach items="${errors}" var="error">
            <p><strong>Fehler: ${error}</strong></p>
        </c:forEach>
        <label for="email">Email:</label><br>
        <input type="email" name="email" id="email" value="interessent3@email.com"><br>
        <label for="passwort">Passwort:</label><br>
        <input type="password" name="passwort" id="passwort" value="123456"><br>
        <button name="btsubmit">Login</button>
    </form>
</body>
</html>
