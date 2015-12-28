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
    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
        }
        html, body {
            height: 100%;
        }
        body {
            background: url("${ctx}/resources/img/bg6.jpg") repeat scroll 0 0 #e4e8eb;
        }
        #wrapper {
            width: 100%;
            display: table;
            height: 100%;
        }
        header{
            /*width: 99%;*/
            /*margin:4px;*/
            height: 26px;
            border-bottom: 1px solid #aaaaaa;
        }
        #center {
            display: table-row;
            height: 100%;
        }
        #content {
            margin: 10px;
        }
        #footer {
            height: 30px;
            background: #f5f5f5;
        }
    </style>

</head>
<body>
<%--<div id="context">--%>
    <%--&lt;%&ndash;Импорт хидера&ndash;%&gt;--%>
    <%--<tiles:insertAttribute name="header"/>--%>
    <%--&lt;%&ndash;------------------------&ndash;%&gt;--%>
    <%--&lt;%&ndash;Импорт контекста&ndash;%&gt;--%>
    <%--<tiles:insertAttribute name="content"/>--%>
    <%--&lt;%&ndash;------------------------&ndash;%&gt;--%>
    <%--&lt;%&ndash;Импорт футтера&ndash;%&gt;--%>
    <%--<tiles:insertAttribute name="footer"/>--%>
    <%--&lt;%&ndash;------------------------&ndash;%&gt;--%>
<%--</div>--%>

<div id="wrapper">
    <tiles:insertAttribute name="header"/>
    <div id="center">
        <div id="content" class="">
            <tiles:insertAttribute name="content"/>
        </div>
    </div>
    <div id="footer" >
        <tiles:insertAttribute name="footer"/>
    </div>
</div>

</body>
</html>
