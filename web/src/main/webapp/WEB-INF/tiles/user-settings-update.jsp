<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container">
    <style scoped="scoped">
        .form-signin {
            max-width: 400px;
            padding: 15px;
            margin: 0 auto;
        }
    </style>
    <div class="container">
        <div class="row">
            <div class="form-signin">
                <h2>Настройки</h2>
                <form:form id="signin" action="${ctx}/user/settings/update" method="post" modelAttribute="userSettForm">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <%--<h2 class="form-signin-heading">Регистрация </h2>--%>
                    <spring:hasBindErrors name="userForm">
                        <div class="form-group">
                            <p class="bg-warning">Заполните все поля правильно!</p>
                        </div>
                    </spring:hasBindErrors>
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
                    <button class="btn btn-primary " type="submit">Обновить</button>
                </form:form>

            </div>
        </div>
    </div>
</div>
