<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:bind path="${param.path}">
    <div class="form-group has-feedback <%= status.isError() ? "has-error" : null != status.getActualValue() ? "has-success" : "" %>">
        <form:input path="${param.path}" type="${param.type}" class="form-control" placeholder="${param.placeholder}"
                    />
        <% if (status.isError()) {%>
        <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>
        <span id="inputSuccess2Status" class="sr-only">(error)</span>
        <%
        } else if (null != status.getActualValue()) {
        %>
        <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
        <span id="inputSuccess2Status" class="sr-only">(success)</span>
        <%}%>
        <div class="help-block with-errors"><form:errors path="${param.path}"/></div>
    </div>
</spring:bind>
