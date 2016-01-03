<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://getbootstrap.com/favicon.ico">
    <jsp:include page="/import/bootstrap.jsp"/>
    <title>Ocge</title>
</head>

<body>

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${ctx}/">рИАВиВРЗ</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <form class="navbar-form navbar-right" action="${ctx}/login" method="post">
                <div class="form-group ">
                    <input id="username" name="username" type="text" placeholder="Логин" class="form-control col-md-1">
                </div>
                <div class="form-group ">
                    <input id="password" name="password"  type="password" placeholder="Пароль" class="form-control col-md-1">
                </div>
                <button type="submit" class="btn btn-success">Войти</button>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </div><!--/.navbar-collapse -->
    </div>
</nav>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <div class="container">
        <h1>Hello, world!</h1>

        <p>This is a template for a simple marketing or informational website. It includes a large callout called a
            jumbotron and three supporting pieces of content. Use it as a starting point to create something more
            unique.</p>

        <p><a class="btn btn-primary btn-lg"
              href="./Jumbotron Template for Bootstrap_files/Jumbotron Template for Bootstrap.html" role="button">Learn
            more »</a></p>
    </div>
</div>

<div class="container">
    <!-- Example row of columns -->
    <div class="row">
        <div class="col-md-4">
            <h2>Heading</h2>

            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris
                condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis
                euismod. Donec sed odio dui. </p>

            <p><a class="btn btn-default"
                  href="./Jumbotron Template for Bootstrap_files/Jumbotron Template for Bootstrap.html" role="button">View
                details »</a></p>
        </div>
        <div class="col-md-4">
            <h2>Heading</h2>

            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris
                condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis
                euismod. Donec sed odio dui. </p>

            <p><a class="btn btn-default"
                  href="./Jumbotron Template for Bootstrap_files/Jumbotron Template for Bootstrap.html" role="button">View
                details »</a></p>
        </div>
        <div class="col-md-4">
            <h2>Heading</h2>

            <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula
                porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut
                fermentum massa justo sit amet risus.</p>
                <a href="${ctx}/ajax/devices/all">devices</a>
                <a href="${ctx}/glavnaya">glavnaya</a>
            <p><a class="btn btn-default"
                  href="./Jumbotron Template for Bootstrap_files/Jumbotron Template for Bootstrap.html" role="button">View
                details »</a></p>
        </div>
    </div>

    <hr>

    <footer>
        <p>© 2015 Company, Inc.</p>
    </footer>
</div> <!-- /container -->

</body>
</html>