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
<!-- External import for bootsrap and jquery -->
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<!-- Css styles for login page, index.jsp  -->
<link href="${pageContext.request.contextPath}/Resources/css/stylesLogin.css" type="text/css" rel="stylesheet">
</head>
	
<body>
	<!-- If user is in session redirect to login servlet -->
	<c:if test="${not empty sessionScope.user}">
  		<c:redirect url="login"/>
  	</c:if>
  	<!-- Main container -->
	<div class="container">
		<div id="login-box">
			<div class="logo">
				<!-- Main logo -->
				<img src="${pageContext.request.contextPath}/Resources/files/logo.png" class="img img-responsive center-block"/>
				<!-- Shopping list caption -->
				<h1 class="logo-caption"><span class="tweak">S</span>HOPPING</h1>
				<h1 class="logo-caption"><span class="tweak">L</span>IST</h1>
			</div><!-- logo -->
			<!-- Go to Sign In -->
			<form class="controls" action="login" method="get">
				<button type="submit" class="btn btn-default btn-block btn-login">Sign In</button>	
			</form><!-- controls -->
			<!-- Go to registration -->
			<form action="register" method="get">	
				<button type="submit" class="btn btn-default btn-block btn-register">Register</button>
			</form>	<!-- register -->
		</div><!-- login-box -->
	</div><!-- container -->
	<!-- Background in the page -->
	<div id="particles-js"></div>
	<!-- Script for background -->
	<script src="${pageContext.request.contextPath}/Resources/js/backgroundShape.js"></script>
</body>
</html>