<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Shopping List - Login Error</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- External import for bootsrap and jquery -->
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<!-- Css styles for login page -->
<link href="${pageContext.request.contextPath}/Resources/css/stylesLogin.css" type="text/css" rel="stylesheet">
<!-- Js script for transition for page -->
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/js/transition.js"></script>
</head>	

<body>
	<!-- Central main container -->
	<div class="container">
		<div id="login-box">
			<!-- Main logo -->
			<div class="logo">
				<img src="${pageContext.request.contextPath}/Resources/files/logo.png" class="img img-responsive center-block"/>
				<!-- Shopping list caption -->
				<h1 class="logo-caption"><span class="tweak">S</span>HOPPING</h1>
				<h1 class="logo-caption"><span class="tweak">L</span>IST</h1>
			</div><!-- logo -->
			<!-- Login form -->	
			<form class="controls" action="j_security_check" method="post">
				<!-- Input - username -->
				<input type="text" name="j_username" placeholder="Username" class="form-control" required autofocus>
				<!-- Input - password -->
				<input type="password" name="j_password" placeholder="Password" class="form-control" required>
				<!-- Send data from form to login controller -->
				<button type="submit" class="btn btn-default btn-block btn-login">Login</button>	
			</form><!-- controls -->
			<!-- Go to registration -->
			<form action="register" method="get">	
				<button type="submit" class="btn btn-default btn-block btn-register">Register</button>
			</form><!-- register -->
			<!-- Error statement -->
			<div class="logo">
				<h3 class="logo-caption">LOGIN <span class="tweak">FAILED</span></h3>
			</div><!-- logo -->
		</div><!-- login-box -->
	</div><!-- container -->
	<!-- Background in the page -->
	<div id="particles-js"></div>
	<!-- Script for background -->
	<script src="${pageContext.request.contextPath}/Resources/js/backgroundShape.js"></script>
</body>
</html>