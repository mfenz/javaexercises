<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit employee</title>
</head>
<body>
<h1>Employee</h1>
<!-- Gibt es Fehler? -->
<c:if test="${!empty errors}">
    <div class="error">
        <!-- Für jeden Eintrag in der Errors-Liste -->
        <c:forEach items="${errors}" var="error">
            <p>${error}</p>
        </c:forEach>
    </div>
</c:if>
<form action="./editemployee?id=${employee.id}" method="post">
    <div>
        <label for="firstname">Firstname:</label>
        <input type="text" name="firstname" id="firstname" value="${employee.firstname}">
    </div>
    <div>
        <label for="lastname">Lastname:</label>
        <input type="text" name="lastname" id="lastname" value="${employee.lastname}">
    </div>
    <div>
        <label for="salary">Salary: </label>
        <input type="text" name="salary" id="salary" value="${employee.salary}">
    </div>
    <div>
        <select name="department_id">
            <c:forEach items="${departments}" var="department">
                <option value="${department.id}" ${department.id == employee.department.id ? 'selected="selected"' : ''}>${department.name}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <button name="btedit">edit employee</button>
    </div>
</form>
</body>
</html>
