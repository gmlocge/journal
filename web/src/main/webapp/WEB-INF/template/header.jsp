<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<header>
    <style>
        #navbar {
            background: #f5f5f5;
        }

        /*#navbar.navbar-form{*/
        /*right: 5px;*/
        /*}*/
    </style>
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${ctx}/">рИАВиВРЗ</a>
            </div>

            <div id="navbar" class="navbar-collapse collapse">
            
                <sec:authorize access="isAuthenticated()">
                    <jsp:include page="headermenu.jsp"/>
                </sec:authorize>
                <%--<sec:authorize access="!isAuthenticated()">--%>
                <%--<form class="navbar-form navbar-right" action="${ctx}/login" method="post">--%>
                    <%--<div class="form-group ">--%>
                        <%--<input id="username" name="username" type="text" placeholder="Логин"--%>
                               <%--class="form-control col-md-1">--%>
                    <%--</div>--%>
                    <%--<div class="form-group ">--%>
                        <%--<input id="password" name="password" type="password" placeholder="Пароль"--%>
                               <%--class="form-control col-md-1">--%>
                    <%--</div>--%>
                    <%--<button type="submit" class="btn btn-success">Войти</button>--%>
                    <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
                <%--</form>--%>
                <%--</sec:authorize>--%>
            </div><!--/.navbar-collapse -->
        </div>
    </nav>
</header>