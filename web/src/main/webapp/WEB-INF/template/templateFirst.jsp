<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title><tiles:getAsString name="titleKey"/></title>
    <meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <%--<link href="${ctx}/resources/favicon.ico" rel="shortcut icon">--%>
    <%--<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/usogdp.css"/>--%>
    <jsp:include page="/WEB-INF/template/includesCSS.jsp"/>
    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
        }
        html, body {
            height: 100%;
            padding-top: 30px;
            padding-bottom: 0;
        }
        #wrapper {
            width: 100%;
            display: table;
            height: 100%;
        }
        #center {
            display: table-row;
            height: 100%;
            /*background: auto;*/
        }
        footer {
            height: 20px;
            background: #f5f5f5;
        }
    </style>

</head>
<body>
<div id="wrapper">
    <jsp:include page="/WEB-INF/template/header.jsp"/>
    <%--<tiles:insertAttribute name="header"/>--%>
    <div id="center">
        <tiles:insertAttribute name="content"/>
    </div>
    <jsp:include page="/WEB-INF/template/footer.jsp"/>
</div>
<jsp:include page="/WEB-INF/template/includesJS.jsp"/>
</body>
</html>
