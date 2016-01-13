<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">

	<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
		<font color="red"> Your login attempt was not successful due to
			<br />
		<br /> <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />.
		</font>
	</c:if>

	<form class="form-signin">
		<h2 class="form-signin-heading">Please sign in</h2>
		<label for="inputEmail" class="sr-only">Email address</label> <input
			type="email" id="inputEmail" class="form-control"
			placeholder="Email address" required="" autofocus=""> <label
			for="inputPassword" class="sr-only">Password</label> <input
			type="password" id="inputPassword" class="form-control"
			placeholder="Password" required="">
		<div class="checkbox">
			<label> <input type="checkbox" value="remember-me">
				Remember me
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
			in</button>
	</form>

</div>
<!-- /container -->
