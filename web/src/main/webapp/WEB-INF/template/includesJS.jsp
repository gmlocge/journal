<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.webjars.org/tags" prefix="wj"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<wj:locate path="bootstrap.min.js" var="bootstrapPathJS"/>
<wj:locate path="jquery.min.js" var="jqueryPathJS"/>
<wj:locate path="tether.min.js" var="tetherPathJS"/>

<%--<c:set var="verBootstrap" scope="request" value="3.3.6"/>--%>
<%--<script type="text/javascript" src="${ctx}/webjars/jquery/1.11.3/jquery.min.js"></script>--%>
<%--<script type="text/javascript" src="${ctx}/webjars/bootstrap/${verBootstrap}/js/bootstrap.min.js"></script>--%>
<%--<script type="application/javascript" src="${ctx}/webjars/jquery/1.11.3/jquery.min.js"></script>--%>
<%--${bootstrapPathJS}--%>
<script type="application/javascript" src="${ctx}/webjars${jqueryPathJS}"></script>
<script type="application/javascript" src="${ctx}/webjars${tetherPathJS}"></script>
<script type="application/javascript" src="${ctx}/webjars${bootstrapPathJS}"></script>

<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">--%>



