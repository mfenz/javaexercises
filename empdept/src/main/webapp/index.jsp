<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<ul>
    <li><a href="./employees">Employees</a></li>
    <li><a href="./departments">Departments</a></li>
    <li><a href="./createdepartment">Create department</a></li>
    <li><a href="./createemployee">Create employee</a></li>
    <li><a href="./addtime">Add project time</a></li>
    <li><a href="./statistics">Statistics</a></li>
    <li><a href="./registration">User registration</a></li>
    <c:if test="${sessionScope.logged_in != true}">
        <li><a href="./login">Login</a></li>
    </c:if>
    <c:if test="${sessionScope.logged_in == true}">
        <li><a href="./profile">Profile</a></li>
        <li><a href="./logout">Logout</a></li>
    </c:if>
</ul>

</body>
</html>