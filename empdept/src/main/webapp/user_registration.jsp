<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<c:if test="${!empty error}">
    <p>${error}</p>
</c:if>
<form method="post" action="./registration">
    <label for="email">Email</label>
    <input type="email" name="email" id="email"><br/>
    <label for="password">Password</label>
    <input type="password" name="password" id="password"><br/>
    <button name="btregistration">Create user</button>
</form>
</body>
</html>
