<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Shopping List</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/Resources/js/custom.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/Resources/css/stylesRegister.css"
	type="text/css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
</head>
<body>
	<div class="container">
		<div id="login-box">
			<div class="logo">
				<img
					src="${pageContext.request.contextPath}/Resources/files/logo.png"
					class="img img-responsive center-block" />
				<h1 class="logo-caption">
					<span class="tweak">R</span>EGISTER <span class="tweak">Y</span>OUR
				</h1>
				<h1 class="logo-caption">
					<span class="tweak">S</span>HOPPING <span class="tweak">L</span>IST
				</h1>
			</div>
			<!-- /.logo -->
			<form class="form-singin" method="post" action="register">
				<input type="text" name="inputUsername" placeholder="Username"
					class="form-control" required autofocus> <input
					type="email" name="inputEmail" placeholder="Email"
					class="form-control" required autofocus> <input
					type="password" name="inputPassword" placeholder="Password"
					class="form-control" required>
				<button type="submit" class="btn btn-default btn-block btn-login">Register
					user</button>
			</form>
			<!-- /.controls -->
			<form action="login">
				<button type="submit" class="btn btn-default btn-block btn-register">Sign
					In</button>
			</form>
			<div class="logo">
				<h3 class="logo-caption">USER <span class="tweak">EXIST</span></h3>
			</div>
			
		</div>
		<!-- /#login-box -->
	</div>
	<!-- /.container -->
	<div id="particles-js"></div>
	<script
		src="${pageContext.request.contextPath}/Resources/js/backgroundShape.js"></script>

</body>
</html>