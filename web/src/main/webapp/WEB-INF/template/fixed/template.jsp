<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <tiles:insertAttribute name="inHeader"/>
    <title><tiles:getAsString name="titleKey"/></title>
    <%--<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>--%>
    <link href="${ctx}/resources/favicon.ico" rel="shortcut icon">
    <%--<meta http-equiv="X-UA-Compatible" content="IE=Edge" />--%>
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/usogdp.css"/>
    <style>
        *, html, body {
            margin: 0 ;
            padding: 0;
        }
        html, body{
            height: 100%;
            width: 100%;
        }
        body {
            background: url("${ctx}/resources/img/bg6.jpg") repeat scroll 0 0 #e4e8eb;
        }
        header{
            height: 26px;
            border-bottom: 2px solid black;
        }
        footer {
            position: absolute;
            bottom: 0;
            width: 100%;
            height: 30px;
            background: #f5f5f5;        }
        #context{
            width: 100%;
            height: 100%;
        }
    </style>
</head>
<body>
<div id="context">
    <%--Импорт хидера--%>
    <tiles:insertAttribute name="header"/>
    <%----------------------------%>
    <%--Импорт контекста--%>
    <tiles:insertAttribute name="content"/>
    <%----------------------------%>
    <%--Импорт футтера--%>
    <%----------------------------%>
</div>
<%--<tiles:insertAttribute name="footer"/>--%>
<%----------------------------%>
</body>
</html>
