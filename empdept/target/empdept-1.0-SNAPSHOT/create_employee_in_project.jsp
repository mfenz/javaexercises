<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mfenz
  Date: 13.08.2021
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add time</title>
</head>
<body>
<h1>Projektzeit hinzufügen</h1>
<form action="./addtime" method="post">
    <div>
        <label for="employee_id">Mitarbeiter: </label>
        <select name="employee_id" id="employee_id">
            <c:forEach items="${employees}" var="employee">
                <option value="${employee.id}">${employee.firstname} ${employee.lastname}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label for="project_id">Projekt: </label>
        <select name="project_id" id="project_id">
            <c:forEach items="${projects}" var="project">
                <option value="${project.id}">${project.name}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label for="start">Start (TT.MM.JJJJ HH:MM)</label>
        <input type="text" name="start" id="start">
    </div>
    <div>
        <label for="end">Ende (TT.MM.JJJJ HH:MM)</label>
        <input type="text" name="end" id="end">
    </div>
    <div>
        <button name="btsubmit">Projektzeit eintragen</button>
    </div>
</form>
</body>
</html>
