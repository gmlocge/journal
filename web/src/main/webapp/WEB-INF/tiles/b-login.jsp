<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${not empty paramValues.auth}">
    <p class="bg-danger"><c:out value="${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}"/>!</p>
</c:if>

<form action="${ctx}/login" method="post">
    <div class="form-group">
        <input id="username" name="username" type="text" placeholder="Логин"
               class="form-control">
    </div>
    <div class="form-group">
        <input id="password" name="password" type="password" placeholder="Пароль"
               class="form-control">
    </div>
    <button type="submit" class="btn btn-success">Войти</button>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>


