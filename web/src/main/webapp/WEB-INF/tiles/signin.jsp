<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
    .form-group.required .control-label:after {
        content: "*";
        color: red;
    }
</style>
<div class="container">
    <div class="row">
        <div class="col-lg-8"></div>
        <div class="col-lg-4">

            <form:form id="signin" method="post" modelAttribute="userForm" action="${ctx}/signin/registration"
                       class="form-signin">
                <%--<form id="signin" class="form-signin" action="${ctx}/signin/registation" method="post" modelAttribute="userForm">--%>
                <h2 class="form-signin-heading">Регистрация</h2>
                <div class="form-group">
                    <%--<input class="form-control" id="inp-login" placeholder="Логин" required>--%>
                    <form:input path="username" type="text" class="form-control" id="inp-login" placeholder="Логин" required="true"/>
                    <div class="help-block with-errors"><form:errors path="username"/></div>
                </div>
                <div class="form-group">
                    <input class="form-control" id="inp-f" placeholder="Фамилия" required>
                </div>
                <div class="form-group">
                    <input class="form-control" id="inp-i" placeholder="Имя" required>
                </div>
                <div class="form-group has-success">
                    <input class="form-control" id="inp-o" placeholder="Отчество" required>
                </div>
                <div class="form-group has-error has-feedback">
                    <input type="text" class="form-control" id="inputSuccess2" aria-describedby="inputSuccess2Status">
                    <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>
                    <span id="inputSuccess2Status" class="sr-only">(error)</span>
                </div>

                <div class="form-group has-success">
                    <label class="control-label" for="inputSuccess1">Input with success</label>
                    <input type="text" class="form-control" id="inputSuccess1" aria-describedby="helpBlock2">
                    <span id="helpBlock2" class="help-block">A block of help text that breaks onto a new line and may extend beyond one line.</span>
                </div>
                <%--<div class="form-group">--%>
                <%--<input type="password" id="inputPassword" class="form-control" placeholder="Password" required>--%>
                <%--</div>--%>
                <%--<label for="inputEmail" class="sr-only">Email address</label>--%>
                <%--<input type="email" id="inputEmail" class="form-control" placeholder="Email address" required="" autofocus="">--%>
                <%--<label for="inputPassword" class="sr-only">Password</label>--%>
                <%--<div class="checkbox">--%>
                <%--<label>--%>
                <%--<input type="checkbox" value="remember-me"> Remember me--%>
                <%--</label>--%>
                <%--</div>--%>
                <button class="btn btn-primary " type="submit">Присоедениться</button>
                <%--</form>--%>
            </form:form>

        </div>
    </div>

</div>
<!-- /container -->

<script>


</script>