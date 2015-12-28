<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- use it for correct load static resourses -->
<c:set var="ctx" scope="request" value="${pageContext.request.contextPath}"/>
<%--for client side , ex. ajax in javaScript--%>
<script>var ctx = "${ctx}";</script>

<link rel="stylesheet" type="text/css" href="${ctx}/webjars/jqgrid/5.0.1/css/ui.jqgrid.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/webjars/jquery-ui-themes/1.11.4/smoothness/jquery-ui.min.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/webjars/bootstrap/3.3.6/css/bootstrap.min.css"/>


<script type="text/javascript" src="${ctx}/webjars/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/webjars/jquery-ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="${ctx}/webjars/jqgrid/5.0.1/js/i18n/grid.locale-ru.js"></script>
<script type="text/javascript" src="${ctx}/webjars/jqgrid/5.0.1/js/minified/jquery.jqGrid.min.js"></script>

<script type="text/javascript" src="${ctx}/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/webjars/noty/2.3.5/js/noty/packaged/jquery.noty.packaged.min.js"></script>


