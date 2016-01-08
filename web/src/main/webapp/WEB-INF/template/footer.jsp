<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<footer >
    <jsp:useBean id="date" class="java.util.Date"/>
    <c:set var="er" value="<%=System.currentTimeMillis()%>"/>
    <c:set var="timeRender" value="${er-ATTR_BEGIN_RENDER}"/>
    <script>var timeRender = "${timeRender}"</script>
    <style>
        .f-line-wrap {
            font-size: 12px;
            line-height: 16px;
            padding: 0 10px;
        }

        .ft-l {
            padding-top: 2px;
            float: left;
        }

        .ft-r {
            padding-top: 2px;
            font-size: 10px;
            float: right;
        }
    </style>
    <div class="container">
        <div class="f-line-wrap">
            <span class="ft-l"><a href="http://ok.ru/taniablack" target="_blank">К кому обратиться?</a>
                <%--| <a href="${ctx}/contacts">Контакты</a>--%>
                </span>
            <span class="ft-r"><fmt:formatDate value="${date}"
                                               pattern="yyyy-MM-dd HH.mm.ss"/>.${timeRender}</span>
        </div>
    </div>
</footer>
