<%-- 
    Document   : kontaktanfrage
    Created on : Aug 4, 2021, 7:52:27 AM
    Author     : mfenz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kontaktanfrage</title>
    </head>
    <body>
        <h1>Kontaktanfrage</h1>
        <c:if test="${not empty error}">
            <p>${error}</p>
        </c:if>
        <c:if test="${not empty anfrage}">
            <p>Name: ${anfrage.name}</p>
            <p>Nachricht: ${anfrage.nachricht}</p>
        </c:if>

    </body>
</html>
