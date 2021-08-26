<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marcfenz
  Date: 20.08.21
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee</title>
</head>
<body>
<h1>Employee</h1>
<c:if test="${!empty error}">
    <div class="error">
        <p>${error}</p>
    </div>
</c:if>
<c:if test="${empty employee}">
    <div class="error">
        <p>Mitarbeiter nicht gefunden</p>
    </div>
</c:if>
<c:if test="${!empty employee}">
    <h2>${employee.firstname} ${employee.lastname}</h2>
    <p>Employee ID: ${employee.id}</p>
    <p>Salary: ${employee.salary} EUR</p>
    <p>Department: ${employee.department.name} (ID: ${employee.department.id})</p>
    <h3>Project contributions</h3>
    <table>
        <thead>
            <tr>
                <th>Project ID</th>
                <th>Project Name</th>
                <th>Start</th>
                <th>End</th>
                <th>Duration</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${employeeInProjectList}" var="eip">
                <tr>
                    <td>${eip.project.id}</td>
                    <td>${eip.project.name}</td>
                    <td>${eip.start}</td>
                    <td>${eip.end}</td>
                    <td>${eip.getDuration()}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>

</body>
</html>
