<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<ul class="nav navbar-nav">
	<li class=""><a href="">Home</a></li>
	<li><a href="about">About</a></li>
	<li><a href="contact">Contact</a></li>
</ul>
<ul class="nav navbar-nav navbar-right">
	<!--             <li><a href="http://getbootstrap.com/examples/navbar/">Default</a></li> -->
	<!--             <li><a href="http://getbootstrap.com/examples/navbar-static-top/">Static top</a></li> -->
	<li class="dropdown"><a href="#" class="dropdown-toggle"
		data-toggle="dropdown" role="button" aria-haspopup="true"
		aria-expanded="false"><sec:authentication
				property="principal.username" /> <span class="caret"></span></a>
		<ul class="dropdown-menu">
			<li><a href="">Настройки</a></li>
			<li><a href="">Смена пароля</a></li>
			<li><a href=""> <sec:authorize access="isAuthenticated()">
						<form method="post"
							action="${pageContext.request.contextPath}/logout"
							id="form-logout">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
							<button type="submit" class="btn btn-link btn-xs">Выйти</button>
						</form>
					</sec:authorize>

			</a></li>
		</ul></li>

</ul>
