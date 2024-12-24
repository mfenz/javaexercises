<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marc
  Date: 03.02.22
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Erstelle Warengruppe</title>
</head>
<body>
<h1>Erstelle Warengruppe</h1>
<form action="./erstellewarengruppe" method="POST">
    <c:forEach items="${errors}" var="error">
        <p><strong>Fehler: ${error}</strong></p>
    </c:forEach>
    <label for="bezeichnung">Bezeichnung:</label><br>
    <input type="text" name="bezeichnung" id="bezeichnung"><br>

    <label for="leiter">Leiter der Warengruppe:</label><br>
    <select name="leiter" id="leiter">
        <c:forEach items="${mitarbeiter}" var="ma">
            <option value="${ma.id}">${ma.vorname} ${ma.nachname}</option>
        </c:forEach>
    </select><br>
    <button name="btsubmit">Warengruppe erstellen</button>
</form>
</body>
</html>
