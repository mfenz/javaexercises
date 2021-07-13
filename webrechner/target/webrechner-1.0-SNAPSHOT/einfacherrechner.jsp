<%-- 
    Document   : einfacherrechner
    Created on : Jul 13, 2021, 8:13:41 AM
    Author     : mfenz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            int zahl1 = 4;
            int zahl2 = 9;
            int ergebnis = zahl1 * zahl2;
        %>
        <h1>Hello World! Ich bin ein Rechner.</h1>
        <% 
            out.print(zahl1 + " x " + zahl2 + " = " + ergebnis);
        %>
    </body>
</html>
