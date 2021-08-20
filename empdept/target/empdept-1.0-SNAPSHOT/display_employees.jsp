<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marcfenz
  Date: 20.08.21
  Time: 08:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
</head>
<body>
<h1>Employees</h1>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Salary</th>
            <th>Department</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${employees}" var="emp">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.firstname}</td>
                <!-- employee?id=5 -->
                <td><a href="./employee?id=${emp.id}">${emp.lastname}</a></td>
                <td>${emp.salary}</td>
                <td>${emp.department.name}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
