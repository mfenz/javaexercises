<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mfenz
  Date: 10.08.2021
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Employee</title>
</head>
<body>
<form action="./createemployee" method="post">
    <div>
        <label for="firstname">Firstname:</label>
        <input type="text" name="firstname" id="firstname">
    </div>
    <div>
        <label for="lastname">Lastname:</label>
        <input type="text" name="lastname" id="lastname">
    </div>
    <div>
        <label for="salary">Salary: </label>
        <input type="text" name="salary" id="salary">
    </div>
    <div>
        <select name="department_id">
            <c:forEach items="${departments}" var="department">
                <option value="${department.id}">${department.name}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <button name="btcreate">create employee</button>
    </div>
</form>
</body>
</html>
