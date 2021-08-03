<%-- 
    Document   : kontaktformular
    Created on : Aug 3, 2021, 9:51:50 AM
    Author     : mfenz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kontaktformular</title>
    </head>
    <body>
        <h1>Kontaktformular</h1>
        <form action="./kontaktformular" method="post">
            <label for="name">Name: </label>
            <input type="text" name="name" id="name"><br/>
            
            <label for="nachricht">Nachricht: </label>
            <textarea name="nachricht" id="nachricht"></textarea><br/>
            
            <button name="btsubmit">Absenden</button>
        </form>
    </body>
</html>
