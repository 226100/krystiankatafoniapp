<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
  <head>
   <meta charset="utf-8">
    <title>Shopping List</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/Resources/css/stylesLogin.css" type="text/css" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	</head>
	
  <body>
	<div class="container">
		<div id="login-box">
			<div class="logo">
				<img src="${pageContext.request.contextPath}/Resources/files/logo.png" class="img img-responsive center-block"/>
				<h1 class="logo-caption"><span class="tweak">S</span>HOPPING</h1>
				<h1 class="logo-caption"><span class="tweak">L</span>IST</h1>
			</div><!-- /.logo -->
			<form class="controls"  method="post">
				<input type="text" name="username" placeholder="Username" class="form-control" required autofocus>
				<input type="password" name="username" placeholder="Password" class="form-control" required>
				<button type="submit" class="btn btn-default btn-block btn-login">Login</button>	
			</form><!-- /.controls -->
			<form action="register" method="get">	
				<button type="submit" class="btn btn-default btn-block btn-register">Register</button>
			</form>
			
		</div><!-- /#login-box -->
	</div><!-- /.container -->
	<div id="particles-js"></div>
	<script src="${pageContext.request.contextPath}/Resources/js/backgroundShape.js"></script>
  </body>
</html>