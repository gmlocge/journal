<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="container">
    <div class="row">
        <div class="col-lg-8">
            <c:if test="${not empty pageContext.request.userPrincipal}">
                <%--<%=request.getUserPrincipal()%>--%>
                <div>
                    <p class="text-danger"><sec:authentication property="principal.authorities"/></p>
                </div>

            </c:if>
            <sec:authorize access="isAuthenticated()">
                <sec:authentication property="principal.username"/>
            </sec:authorize>
        </div>
        <div class="col-lg-4">
            <ul id="roleTabs" class="nav nav-tabs">
                <li class="active"><a href="#tlogin" aria-controls="tlogin" role="tab" data-toggle="tab">Вход</a></li>
                <li><a href="#tsignin" aria-controls="tsignin" role="tab" data-toggle="tab">Регистрация</a></li>
            </ul>
            <!-- Tab panes -->
            <div class="tab-content">
                <div id="tlogin" class="tab-pane fade in active">
                    <br>
                    <jsp:include page="b-login.jsp"/>
                </div>
                <div id="tsignin" class="tab-pane fade">
                    <br>
                    <jsp:include page="b-signin.jsp"/>
                </div>
            </div>
            <%--<div>--%>
            <%--<jsp:include page="login.jsp"/>--%>
            <%--</div>--%>
            <%--<div>--%>
            <%--<jsp:include page="signin.jsp"/>--%>
            <%--</div>--%>
        </div>
    </div>
</div>
