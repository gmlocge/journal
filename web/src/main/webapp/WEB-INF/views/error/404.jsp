<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isErrorPage="true" %>
<%--<html>--%>
<%--<head>--%>
<%--<title><spring:message code="errors.error"/></title>--%>
<%--</head>--%>
<%--<body>--%>
<div class="container">
    <h2>Запрашиваемая страница не найдена</h2>
    <br/>
    <button class="btn btn-primary" onclick="history.back()">Вернуться на предыдущую страницу</button>
    <br/>
    <br/>
    <%--<p><b>Код:</b> ${pageContext.errorData.statusCode}</p>--%>
    <p class="text-info"><b>Запрашиваемый URI:</b> ${pageContext.request.scheme}://${header.host}${pageContext.errorData.requestURI}</p>
</div>
<%--<div align="center">--%>
<%--<span><img src="/resources/images/error404.jpg"></span>--%>
<%--</div>--%>

<%--</body>--%>
<%--</html>--%>