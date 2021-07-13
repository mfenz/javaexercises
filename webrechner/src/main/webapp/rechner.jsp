<%-- 
    Document   : rechner
    Created on : Jul 13, 2021, 8:22:23 AM
    Author     : mfenz
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Addition</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    </head>
    <body>
        <h1>Addition von zwei Zahlen</h1>
        <%
            List<String> errors = new ArrayList<>();
            if (request.getParameter("btsubmit") != null) {
                String z1 = request.getParameter("z1");

                int zahl1 = 0;
                int zahl2 = 0;

                // Prüfen ob die Eingabe korrekt war, und Eingabe in int umwandeln
                if (z1 == null || z1.isBlank()) {
                    errors.add("Bitte Zahl 1 eingeben.");
                } else {
                    // String in int umwandeln
                    try {
                        zahl1 = Integer.parseInt(z1);
                    } catch (NumberFormatException e) {
                        errors.add("Zahl 1 ist keine Zahl.");
                    }
                }

                try {
                    zahl2 = Integer.parseInt(request.getParameter("z2"));
                } catch (NumberFormatException | NullPointerException e) {
                    errors.add("Bitte die Eingabe für Zahl 2 prüfen.");
                }

                // wenn es keine Fehler gibt ... 
                if (errors.isEmpty()) {
                    // Berechnung durchführen
                    int ergebnis = zahl1 + zahl2;
                    // Ausgabe
        %>
        <div class="result">
            <p><% out.print(zahl1 + " + " + zahl2 + " = " + ergebnis); %></p>
        </div>
        <%
                } else {
                    // Fehlermeldungen ausgeben
                    out.print("<div class=\"error\">");

                    // Errors-List iterieren, und Fehler für Fehler ausgeben
                    Iterator<String> iter = errors.iterator();
                    while (iter.hasNext()) {
                        String error = iter.next();
                        out.print("<p>" + error + "</p>");
                    }

                    out.print("</div>");
                }

            } else if (request.getParameter("btzugoogle") != null) {
                // Suchanfrage zu Google weiterleiten

                // Suchanfrage einlesen
                String suche = request.getParameter("suchanfrage");

                // Mit der Suchanfrage zu Google weiterleiten
                // https://www.google.at/search?q=asdf
                response.sendRedirect("https://www.google.at/search?q=" + suche);
            }
        %>
        <form action="rechner.jsp" method="post">
            Zahl 1: <input type="text" name="z1"><br/>
            Zahl 2: <input type="text" name="z2"><br/>
            <button name="btsubmit">Zahl 1 + Zahl 2</button>
        </form>
        <p>
            In z1 steht: <%= request.getParameter("z1")%>
        </p>
        <h3>Oder wollen Sie zu Google?</h3>
        <form action="rechner.jsp" method="post">
            Suche nach: <input type="text" name="suchanfrage"><br/>
            <button name="btzugoogle">Auf Google suchen</button>
        </form>
    </body>
</html>
