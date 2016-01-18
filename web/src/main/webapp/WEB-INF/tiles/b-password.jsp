<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<form:form id="signin" action="${ctx}/user/password/update" method="post" modelAttribute="passwordForm">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <%--<h2 class="form-signin-heading">Регистрация </h2>--%>
    <spring:hasBindErrors name="passwordForm">
        <div class="form-group">
            <p class="bg-warning">Заполните все поля правильно!</p>
        </div>
    </spring:hasBindErrors>
    <jsp:include page="taginput.jsp">
        <jsp:param name="path" value="passwordOld"/>
        <jsp:param name="type" value="password"/>
        <jsp:param name="placeholder" value="Текущий пароль"/>
    </jsp:include>
    <jsp:include page="taginput.jsp">
        <jsp:param name="path" value="passwordNew"/>
        <jsp:param name="type" value="password"/>
        <jsp:param name="placeholder" value="Новый пароль"/>
    </jsp:include>
    <jsp:include page="taginput.jsp">
        <jsp:param name="path" value="passwordConfirm"/>
        <jsp:param name="type" value="password"/>
        <jsp:param name="placeholder" value="Повторите новый пароль"/>
    </jsp:include>
    <button class="btn btn-primary " type="submit">Сменить пароль</button>
</form:form>