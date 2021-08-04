<%-- 
    Document   : kontaktanfragen
    Created on : Aug 3, 2021, 11:27:42 AM
    Author     : mfenz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Kontaktanfragen</h1>
        <p>
            <a href="./kontaktformular">Kontaktformular</a>
        </p>
        <c:forEach items="${anfragen}" var="anfrage">
            <!-- to do Ausgabe sichern! -->
            <div>
                <h3>${anfrage.name}</h3>
                <p>${anfrage.nachricht}</p>
                <p>
                    <a href="./bearbeiten?id=${anfrage.id}">Bearbeiten</a>
                </p>
                <p><a href="./kontaktanfrage?id=${anfrage.id}">Kontaktanfrage ansehen</a></p>
                <form action="./loeschen" method="post">
                    <input type="hidden" name="id" value="${anfrage.id}" />
                    <button name="btdelete">Löschen</button>
                </form>
            </div>
        </c:forEach>
        <!-- wenn nix drinn ist -->
        <c:if test="${empty anfragen}">
            <p>Es sind keine Kontaktanfragen vorhanden.</p>
        </c:if>
    </body>
</html>
