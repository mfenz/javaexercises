<%-- 
    Document   : kontaktanfragebearbeiten
    Created on : Aug 3, 2021, 7:35:28 PM
    Author     : mfenz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kontaktanfrage bearbeiten</title>
    </head>
    <body>
        <h1>Kontaktanfrage bearbeiten</h1>
        <form action="./bearbeiten?id=${kontaktanfrage.id}" method="post">
            <label for="name">Name: </label>
            <input type="text" name="name" id="name" value="${kontaktanfrage.name}"><br/>
            
            <label for="nachricht">Nachricht: </label>
            <textarea name="nachricht" id="nachricht">${kontaktanfrage.nachricht}</textarea><br/>
            
            <button name="btsubmit">Bearbeiten</button>
        </form>
    </body>
</html>
