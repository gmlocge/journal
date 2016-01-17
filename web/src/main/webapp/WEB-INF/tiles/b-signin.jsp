<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<form:form id="signin" action="${ctx}/signin" method="post" modelAttribute="userForm">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <%--<h2 class="form-signin-heading">Регистрация </h2>--%>
    <spring:hasBindErrors name="userForm">
        <div class="form-group">
            <p class="bg-warning">Заполните все поля правильно!</p>
        </div>
    </spring:hasBindErrors>
    <jsp:include page="taginput.jsp">
        <jsp:param name="path" value="username"/>
        <jsp:param name="type" value="text"/>
        <jsp:param name="placeholder" value="Логин"/>
    </jsp:include>
    <jsp:include page="taginput.jsp">
        <jsp:param name="path" value="firstName"/>
        <jsp:param name="type" value="text"/>
        <jsp:param name="placeholder" value="Имя"/>
    </jsp:include>
    <jsp:include page="taginput.jsp">
        <jsp:param name="path" value="middleName"/>
        <jsp:param name="type" value="text"/>
        <jsp:param name="placeholder" value="Отчество"/>
    </jsp:include>
    <jsp:include page="taginput.jsp">
        <jsp:param name="path" value="lastName"/>
        <jsp:param name="type" value="text"/>
        <jsp:param name="placeholder" value="Фамилия"/>
    </jsp:include>
    <jsp:include page="taginput.jsp">
        <jsp:param name="path" value="password"/>
        <jsp:param name="type" value="password"/>
        <jsp:param name="placeholder" value="Пароль"/>
    </jsp:include>
    <button class="btn btn-primary " type="submit">Присоедениться</button>
</form:form>