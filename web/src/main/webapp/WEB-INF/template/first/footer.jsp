<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="date" class="java.util.Date"/>
<c:set var="er" value="<%=System.currentTimeMillis()%>"/>
<c:set var="timeRender" value="${er-ATTR_BEGIN_RENDER}"/>
<script>var timeRender = "${timeRender}"</script>
<footer>
<style>
    .f-line-wrap {
        line-height: 27px;
        padding: 0 28px
    }
    .ft-l {
        float: left;
    }
    .ft-r {
        float: right;
    }

    #linkapi{
        color: inherit;
    }
</style>
<div class="f-line-wrap">
    <span class="ft-l"><a href="http://www.rw.by/corporate/structure/ktc/" target="_blank">КТЦ</a> | <a href="${ctx}/contacts">Контакты разработчиков</a></span>
    <span class="ft-r">Cгенерировано <fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH.mm.ss.SSS"/> за ${timeRender} мс</span>
</div>
</footer>
