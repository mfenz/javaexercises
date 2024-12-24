<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marc
  Date: 03.02.22
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Benutzer bearbeiten</title>
    <h1>Benutzer bearbeiten</h1>
    <form action="./benutzerbearbeiten?id=${benutzer.id}" method="POST">
        <input type="hidden" name="id" value="${benutzer.id}">
        <label for="vorname">Vorname:</label><br>
        <input type="text" name="vorname" id="vorname" value="${benutzer.vorname}"><br>
        <label for="nachname">Nachname:</label><br>
        <input type="text" name="nachname" id="nachname" value="${benutzer.nachname}"><br>
        <label for="email">Email:</label><br>
        <input type="email" name="email" id="email" value="${benutzer.email}"><br>
        <label for="passwort">Passwort:</label><br>
        <input type="password" name="passwort" id="passwort"><br>

        <label for="warengruppe">Warengruppe:</label><br>
        <select id="warengruppe" name="warengruppe">
            <option value="">Keine</option>
            <c:forEach items="${warengruppen}" var="w">
            <option value="${w.id}" <c:if test="${benutzer.getWarengruppeId().isPresent() && benutzer.getWarengruppeId().get() == w.id}">selected</c:if> >${w.bezeichnung}</option>
            </c:forEach>
        </select><br><br>


        <input type="checkbox" name="admin" id="admin" <c:if test="${benutzer.isAdmin()}">checked="checked"</c:if>>
        <label for="admin">Administrator</label><br><br>

        <input type="radio" name="benutzertyp" value="mitarbeiter" id="mitarbeiter" <c:if test="${benutzer.isMitarbeiter()}">checked="checked"</c:if>>
        <label for="mitarbeiter">Mitarbeiter</label>
        <input type="radio" name="benutzertyp" value="interessent" id="interessent" <c:if test="${benutzer.isInteressent()}">checked="checked"</c:if>>
        <label for="interessent">Interessent</label><br>

        <fieldset>
            <legend>Nur für Interessenten auszufüllen</legend>
            <label for="strasse">Straße:</label><br>
            <input type="text" name="strasse" id="strasse" value="${benutzer.getInteressent().isPresent() ? benutzer.getInteressent().get().strasse : ''}"><br>
            <label for="plz">Plz:</label><br>
            <input type="text" name="plz" id="plz" value="${benutzer.getInteressent().isPresent() ? benutzer.getInteressent().get().plz : ''}"><br>
            <label for="ort">Ort:</label><br>
            <input type="text" name="ort" id="ort" value="${benutzer.getInteressent().isPresent() ? benutzer.getInteressent().get().ort : ''}"><br>
            <label for="firmenname">Firmenname:</label><br>
            <input type="text" name="firmenname" id="firmenname" value="${benutzer.getInteressent().isPresent() ? benutzer.getInteressent().get().firmenname : ''}"><br>
        </fieldset>

        <button>Benutzer bearbeiten</button>

    </form>
</head>
<body>

</body>
</html>
