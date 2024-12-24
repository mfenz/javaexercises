<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marc
  Date: 31.01.22
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Admin-Übersicht</h1>
<p>Herzlich willkommen ${current_benutzer.vorname} ${current_benutzer.nachname}</p>
<h2>Benutzerverwaltung</h2>
<ul>
    <li><a href="./benutzererstellen">Benutzer erstellen</a></li>
</ul>

<h3>Alle Benutzer</h3>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Warengruppe-ID</th>
        <th>Rolle</th>
        <th>Bearbeiten</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${benutzer}" var="b">
        <tr>
            <td>${b.id}</td>
            <td>${b.nachname}, ${b.vorname}</td>
            <td>${b.email}</td>

            <td>
                <!-- IF-Else (für Warengruppe) -->
                <c:choose>
                    <c:when test="${b.warengruppeId.isPresent()}">
                        ${b.warengruppeId.get()}
                    </c:when>
                    <c:otherwise>
                        Keine Warengruppe
                    </c:otherwise>
                </c:choose>
            </td>

            <!-- Alle Rollen -->
            <td>
                <c:forEach items="${b.rollen}" var="rolle">
                    ${rolle.name},
                </c:forEach>
            </td>

            <td>
                <a href="./benutzerbearbeiten?id=${b.id}">Bearbeiten</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<h3>Alle Mitarbeiter (User)</h3>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Warengruppe-ID</th>
        <th>Rolle</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${mitarbeiter}" var="b">
        <tr>
            <td>${b.id}</td>
            <td>${b.nachname}, ${b.vorname}</td>
            <td>${b.email}</td>

            <td>
                <!-- IF-Else (für Warengruppe) -->
                <c:choose>
                    <c:when test="${b.warengruppeId.isPresent()}">
                        ${b.warengruppeId.get()}
                    </c:when>
                    <c:otherwise>
                        Keine Warengruppe
                    </c:otherwise>
                </c:choose>
            </td>

            <!-- Alle Rollen -->
            <td>
                <c:forEach items="${b.rollen}" var="rolle">
                    ${rolle.name},
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<h3>Alle Administratoren</h3>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Warengruppe-ID</th>
        <th>Rolle</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${administratoren}" var="b">
        <tr>
            <td>${b.id}</td>
            <td>${b.nachname}, ${b.vorname}</td>
            <td>${b.email}</td>

            <td>
                <!-- IF-Else (für Warengruppe) -->
                <c:choose>
                    <c:when test="${b.warengruppeId.isPresent()}">
                        ${b.warengruppeId.get()}
                    </c:when>
                    <c:otherwise>
                        Keine Warengruppe
                    </c:otherwise>
                </c:choose>
            </td>

            <!-- Alle Rollen -->
            <td>
                <c:forEach items="${b.rollen}" var="rolle">
                    ${rolle.name},
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<h2>Warengruppenverwaltung</h2>
<ul>
    <li><a href="./warengruppeerstellen">Warengruppe erstellen</a></li>
</ul>

<h3>Alle Warengruppen</h3>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Bezeichnung</th>
            <th>Leiter</th>
            <th>Dokumente hinzufügen</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${warengruppen}" var="w">
            <tr>
                <td>${w.id}</td>
                <td>${w.bezeichnung}</td>
                <td>${w.leiter.vorname} ${w.leiter.nachname}</td>
                <td>
                    <a href="./warengruppe?id=${w.id}">Dokumente</a>
                </td>
            </tr>
        </c:forEach>

    </tbody>
</table>

<h2>Logout</h2>
<form action="./../logout" method="POSt">
    <button>Logout</button>
</form>

</body>
</html>
