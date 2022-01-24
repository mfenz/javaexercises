<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marc
  Date: 24.01.22
  Time: 08:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Guestbook</h1>

<h2>Leave a message</h2>

<p>Spam verboten! Wir kennen Ihre IP (${ip}) und welchen Browser (${browser}) Sie verwenden!</p>

<!-- http://localhost:8080/20220117guestbook_war_exploded/ -->
<!-- / wäre http://localhost:8080/ -->
<!-- ./ wäre http://localhost:8080/20220117guestbook_war_exploded/ -->
<form action="./" method="POST">

    <c:if test="${not empty error}">
        <p>${error}</p>
    </c:if>

    <label for="name">Name:</label><br>
    <input type="text" id="name" name="name" value="${form_name}"><br>

    <label for="email">Email:</label><br>
    <input type="email" id="email" name="email" value="${form_email}"><br>

    <label for="text">Message:</label><br>
    <textarea id="text" name="text" value="${form_text}">

    </textarea><br>

    <button name="btsubmit">Send message</button>
</form>

<h2>Previous messages</h2>

<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Text</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${entries}" var="entry">
            <tr>
                <td>${entry.id}</td>
                <td>${entry.name}</td>
                <td>${entry.email}</td>
                <td>${entry.text}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>
