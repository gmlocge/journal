<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<sec:authorize access="hasRole('ROLE_USOGDP')">--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<c:forEach var="mainItem" items="${usogdpmenu.menuItems}">--%>
<%--<div class="btn-group">--%>
<%--<button class="btn btn-default btn-xs dropdown-toggle" type="button" data-toggle="dropdown"--%>
<%--aria-haspopup="true" aria-expanded="false">${mainItem.name} <span class="caret"></span></button>--%>
<%--<ul class="dropdown-menu">--%>
<%--<c:forEach var="item" items="${mainItem.children}">--%>
<%--<c:if test="${not empty item.urlSystem}">--%>
<%--<li><a href="${item.urlSystem}${item.url}">${item.name}</a></li>--%>
<%--</c:if>--%>
<%--<c:if test="${empty item.urlSystem}">--%>
<%--<li><a href="${item.url}">${item.name}</a></li>--%>
<%--</c:if>--%>
<%--</c:forEach>--%>
<%--</ul>--%>
<%--</div>--%>
<%--</c:forEach>--%>

<style>
    #betw-items{
        margin-left: 7px;
        margin-right: 7px;
    }
    .menuinh{
        color: #333333;
    }
</style>
<%--Статическая часть меню--%>

<div class="btn-group">
    <a href="${ctx}/" class="menuinh">Журнал</a>
</div>
<span id="betw-items">|</span>
<div class="btn-group">
    <a href="${ctx}/districts" class="menuinh">График</a>
</div>
<span id="betw-items">|</span>
<div class="btn-group">
    <a href="${ctx}" class="dropdown-toggle menuinh" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Инструменты<span
            class="caret"></span></a>
    <ul class="dropdown-menu">
        <li><a  href="${ctx}/emptyvagons">Регулировка порожних вагонов</a></li>
        <%--<li><a href="${ctx}/stascript">Станции моделирования</a></li>--%>
        <li><a  href="${ctx}/stamod">Станции отображения</a></li>
        <%--<li><a href="${ctx}/texpage">Технологическая страница</a></li>--%>
    </ul>
</div>
<span id="betw-items">|</span>
<div class="btn-group">
    <a href="${ctx}" class="dropdown-toggle menuinh" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Справка<span
            class="caret"></span></a>
    <ul class="dropdown-menu">
        <li><a href="${ctx}/help" class="menuinh">Руководство пользователя</a></li>
        <li><a href="${ctx}/contacts">Контакты</a></li>
        <%--<li><a href="${ctx}/stascript">Станции моделирования</a></li>--%>
        <%--<li><a  href="${ctx}/stamod">Станции отображения</a></li>--%>
        <%--<li><a href="${ctx}/texpage">Технологическая страница</a></li>--%>
    </ul>
</div>
<%--<div class="btn-group pull-right h-r-ch">--%>
    <%--<a href="${ctx}/help" class="menuinh">Справка</a>--%>
<%--</div>--%>


<%--<sec:authorize access="hasRole('ROLE_USOGDP')">--%>
<%--<div class="btn-group">--%>
<%--<button class="btn btn-default btn-xs dropdown-toggle" type="button" data-toggle="dropdown"--%>
<%--aria-haspopup="true" aria-expanded="false">УСОГДП<span class="caret"></span></button>--%>
<%--<ul class="dropdown-menu">--%>
<%--<li><a href="${ctx}">Главная</a></li>--%>
<%--<li><a href="${ctx}/districts">График</a></li>--%>
<%--</ul>--%>
<%--</div>--%>
<%--</sec:authorize>--%>

<%--<sec:authorize access="hasRole('ROLE_USOGDP')">--%>
<%--<div class="btn-group">--%>
<%--&lt;%&ndash;<button class="btn btn-default btn-sm dropdown-toggle" type="button" data-toggle="dropdown"&ndash;%&gt;--%>
<%--&lt;%&ndash;aria-haspopup="true" aria-expanded="false">Инструменты<span class="caret"></span></button>&ndash;%&gt;--%>
<%--<a class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Инструменты<span class="caret"></span></a>--%>
<%--<ul class="dropdown-menu">--%>
<%--<li><a href="${ctx}/emptyvagons">Регулировка порожних вагонов</a></li>--%>
<%--<li><a href="${ctx}/stascript">Станции моделирования</a></li>--%>
<%--</ul>--%>
<%--</div>--%>
<%--</sec:authorize>--%>

<%--<sec:authorize access="hasRole('ROLE_USOGDP_TESTER')">--%>

<%--<div class="btn-group">--%>
<%--<button class="btn btn-default btn-xs dropdown-toggle" type="button" data-toggle="dropdown"--%>
<%--aria-haspopup="true" aria-expanded="false">Дебаг<span class="caret"></span></button>--%>
<%--<ul class="dropdown-menu">--%>
<%--<li><a href="${ctx}/api1">API ajax</a></li>--%>
<%--<li><a href="${ctx}/reference">reference</a></li>--%>
<%--</ul>--%>
<%--</div>--%>
<%--</sec:authorize>--%>