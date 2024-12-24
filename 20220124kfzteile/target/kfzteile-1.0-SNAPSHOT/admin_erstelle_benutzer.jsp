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
    <title>Benutzer erstellen</title>
    <h1>Benutzer erstellen</h1>
    <form action="./benutzererstellen" method="POST">
        <label for="vorname">Vorname:</label><br>
        <input type="text" name="vorname" id="vorname"><br>
        <label for="nachname">Nachname:</label><br>
        <input type="text" name="nachname" id="nachname"><br>
        <label for="email">Email:</label><br>
        <input type="email" name="email" id="email"><br>
        <label for="passwort">Passwort:</label><br>
        <input type="password" name="passwort" id="passwort"><br>

        <label for="warengruppe">Warengruppe:</label><br>
        <select id="warengruppe" name="warengruppe">
            <option value="">Keine</option>
            <c:forEach items="${warengruppen}" var="w">
                <option value="${w.id}">${w.bezeichnung}</option>
            </c:forEach>
        </select><br><br>

        <input type="checkbox" name="admin" id="admin">
        <label for="admin">Administrator</label><br>
        <br>

        <input type="radio" name="benutzertyp" value="mitarbeiter" id="mitarbeiter">
        <label for="mitarbeiter">Mitarbeiter</label>
        <input type="radio" name="benutzertyp" value="interessent" id="interessent">
        <label for="interessent">Interessent</label><br>

        <fieldset>
            <legend>Nur für Interessenten auszufüllen</legend>
            <label for="strasse">Straße:</label><br>
            <input type="text" name="strasse" id="strasse"><br>
            <label for="plz">Plz:</label><br>
            <input type="text" name="plz" id="plz"><br>
            <label for="ort">Ort:</label><br>
            <input type="text" name="ort" id="ort"><br>
            <label for="firmenname">Firmenname:</label><br>
            <input type="text" name="firmenname" id="firmenname"><br>
        </fieldset>

        <button>Benutzer erstellen</button>

    </form>
</head>
<body>

</body>
</html>
