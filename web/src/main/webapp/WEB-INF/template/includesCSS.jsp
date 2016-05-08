<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.webjars.org/tags" prefix="wj"%>
<wj:locate path="bootstrap.min.css" var="bootstrapPathCSS"/>
<c:set var="ctx" scope="request" value="${pageContext.request.contextPath}"/>
<%--for client side , ex. ajax in javaScript--%>
<script>var ctx = "${ctx}";</script>

<%--3.3.6 4.0.0-alpha--%>
<%-- important!!! we use agnostic version for webjar  type="text/css"   --%>
<link rel="stylesheet" type="text/css" href="${ctx}/webjars${bootstrapPathCSS}"/>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/my.css"/>
<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">--%>



