<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marcfenz
  Date: 15.11.21
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8" />
    <title>Page Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>
<!-- HEADER mit Menü -->
<%@include file="header.jsp"%>

<!-- Inhalt der Seite -->
<main class="center-wrapper">
    <h1>Registrieren</h1>
    <%@include file="errors.jsp"%>

    <form action="./register" method="POST">
        <div>
            <label for="name">Name</label><br/>
            <input type="text" name="name" id="name">
        </div>
        <div>
            <label for="email">Email</label><br/>
            <input type="email" name="email" id="email">
        </div>
        <div>
            <label for="password">Passwort:</label><br/>
            <input type="password" name="password" id="password">
        </div>
        <div>
            <button name="btsubmit">Registrieren</button>
        </div>
    </form>
</main>

</body>
</html>