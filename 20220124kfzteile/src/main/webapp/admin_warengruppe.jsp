<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marc
  Date: 04.02.22
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Warengruppe</title>
</head>
<body>
<h1>Warengruppe: ${warengruppe.bezeichnung}</h1>
<h2>Dokumente</h2>
<ul>
    <c:forEach items="${warengruppe.dokumente}" var="dokument">
        <li>${dokument.pfad} ${dokument.dateiname}</li>
    </c:forEach>
</ul>

<h2>Dokumente hinzufügen</h2>
<form action="./warengruppe?id=${warengruppe.id}" method="POST">
    <input type="hidden" name="id" value="${warengruppe.id}">

    <label for="pfad">Pfad: (mit / am Ende)</label><br>
    <input type="text" name="pfad" id="pfad"><br>

    <label for="dateiname">Dateiname</label><br>
    <input type="text" name="dateiname" id="dateiname"><br>

    <button name="btsubmit">Dokument anlegen</button>
</form>

</body>
</html>
