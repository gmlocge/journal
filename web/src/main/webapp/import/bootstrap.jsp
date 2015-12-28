<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- use it for correct load static resourses -->
<c:set var="ctx" scope="request" value="${pageContext.request.contextPath}"/>
<%--<c:set var="verBootstrap" scope="request" value="4.0.0-alpha"/>--%>
<c:set var="verBootstrap" scope="request" value="3.3.6"/>
<%--for client side , ex. ajax in javaScript--%>
<script>var ctx = "${ctx}";</script>
<%--3.3.6 4.0.0-alpha--%>
<link rel="stylesheet" type="text/css" href="${ctx}/webjars/bootstrap/${verBootstrap}/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="http://getbootstrap.com/examples/jumbotron/jumbotron.css"/>
<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">--%>
<script type="text/javascript" src="${ctx}/webjars/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/webjars/bootstrap/${verBootstrap}/js/bootstrap.min.js"></script>



