<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8" />
    <title>Page Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>
<!-- HEADER mit Menü -->
<%@include file="header.jsp"%>

<!-- Inhalt der Seite -->
<main class="center-wrapper">
    <h1>Immobilie: ${immo.id}</h1>

    <form enctype="multipart/form-data" action="./admin-immo" method="POST">
        <div>
            Datei wählen:
            <input type="file" name="file">
        </div>
        <button name="btupload">Upload</button>
    </form>
</main>

</body>
</html>