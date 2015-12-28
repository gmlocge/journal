<%--<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java"%>--%>
<%--<jsp:forward page="/main"></jsp:forward>--%>

<%--<%@ page errorPage="WEB-INF/views/usogdp-errortrace.jsp" %>--%>

<html>
<head>
  <title>Error Handling Example</title>
</head>
<body>
<%
  // Throw an exception to invoke the error page
  int x = 1;
  if (x == 1)
  {
    throw new RuntimeException("Test RuntimeException,  condition!!!");
  }
%>
</body>
</html>