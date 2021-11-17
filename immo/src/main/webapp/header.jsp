<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="center-wrapper">
    <div class="title">Meine Seite</div>
    <div class="menu">
        <ul>
            <li><a href="./">Home</a></li>
            <c:if test="${!logged_in}">
                <li><a href="./register">Registrieren</a></li>
                <li><a href="./login">Login</a></li>
            </c:if>
            <c:if test="${logged_in}">
                <li><a href="./logout">Logout</a></li>
            </c:if>
            <c:if test="${is_admin}">
                <li><a href="./admin">Admin</a></li>
            </c:if>
        </ul>
    </div>
</header>