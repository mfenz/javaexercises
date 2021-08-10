<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: mfenz
  Date: 10.08.2021
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Departments</title>
</head>
<body>
<h1>Departments</h1>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${departments}" var="department">
            <tr>
                <td>${department.id}</td>
                <td>${department.name}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>
