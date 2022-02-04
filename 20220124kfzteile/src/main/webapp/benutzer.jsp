<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marc
  Date: 04.02.22
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Benutzer</title>
</head>
<body>
<h1>Benutzer</h1>
<p>Guten Tag ${benutzer.vorname} ${benutzer.nachname}</p>
<p>Email: ${benutzer.email}</p>
<c:if test="${benutzer.getInteressent().isPresent()}">
    <p>
        Adresse: ${benutzer.getInteressent().get().strasse},
            ${benutzer.getInteressent().get().plz},
            ${benutzer.getInteressent().get().ort}
    </p>
</c:if>

<h2>Warengruppen</h2>
<c:if test="${warengruppe != null}">
    <div>
        <p>Ihre Warengruppe: ${warengruppe.bezeichnung}</p>
        <h3>Dokumente (klick zum Download):</h3>
        <ul>
            <c:forEach items="${warengruppe.dokumente}" var="dokument">
                <li><a href="./dokument?id=${dokument.id}">Download: ${dokument.dateiname}</a></li>
            </c:forEach>
        </ul>
    </div>
</c:if>

<h2>Passwort ändern</h2>
<form action="./updatepasswort" method="POST">
    <label for="passwort">Neues Passwort:</label><br>
    <input type="password" name="passwort" id="passwort"><br>
    <button name="btchangepassword">Passwort ändern</button>
</form>

<h2>Logout</h2>
<form action="./../logout" method="POSt">
    <button>Logout</button>
</form>

</body>
</html>
