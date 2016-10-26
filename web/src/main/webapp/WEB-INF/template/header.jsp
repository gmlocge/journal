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
    <div class="container">
        <nav class="navbar navbar-fixed-top navbar-light bg-faded">
            <a class="navbar-brand" href="${ctx}/">рИАВиВРЗ</a>

            <sec:authorize access="isAuthenticated()">
                <jsp:include page="headermenu.jsp"/>
            </sec:authorize>
            <%--<ul class="nav navbar-nav">--%>
            <%--<li class="nav-item active">--%>
            <%--<a class="nav-link" href="#">Home </a>--%>
            <%--</li>--%>
            <%--<li class="nav-item">--%>
            <%--<a class="nav-link" href="#">Features</a>--%>
            <%--</li>--%>
            <%--<li class="nav-item">--%>
            <%--<a class="nav-link" href="#">Pricing</a>--%>
            <%--</li>--%>
            <%--<li class="nav-item">--%>
            <%--<a class="nav-link" href="#">About</a>--%>
            <%--</li>--%>
            <%--<li class="nav-item">--%>
            <%--<a class="nav-link" href="#">About</a>--%>
            <%--</li>--%>
            <%--<li class="nav-item">--%>
            <%--<a class="nav-link" href="#">About</a>--%>
            <%--</li>--%>
            <%--<li class="nav-item">--%>
            <%--<a class="nav-link" href="#">About</a>--%>
            <%--</li>--%>
            <%--</ul>--%>
        </nav>
    </div>


    <%--<nav class="navbar navbar-default navbar-fixed-top">--%>
    <%--<div class="container">--%>
    <%--<div class="navbar-header">--%>
    <%--<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"--%>
    <%--aria-expanded="false" aria-controls="navbar">--%>
    <%--<span class="sr-only">Toggle navigation</span>--%>
    <%--<span class="icon-bar"></span>--%>
    <%--<span class="icon-bar"></span>--%>
    <%--<span class="icon-bar"></span>--%>
    <%--</button>--%>
    <%--<a class="navbar-brand" href="${ctx}/">рИАВиВРЗ</a>--%>
    <%--</div>--%>

    <%--<div id="navbar" class="navbar-collapse collapse">--%>
    <%----%>
    <%--<sec:authorize access="isAuthenticated()">--%>
    <%--<jsp:include page="headermenu.jsp"/>--%>
    <%--</sec:authorize>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</nav>--%>
</header>