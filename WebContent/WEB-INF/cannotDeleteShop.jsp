
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<!-- Close page after 3sec, redirect to shop controller -->
<meta http-equiv="refresh" content="3; url=shop" />
<title>Shopping List - Cannot delete Shop</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- External imports for jquery, animations, boostrap  -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
<!-- Css styles for cannotDeleteShop -->
<link href="${pageContext.request.contextPath}/Resources/css/stylesInterface.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/Resources/css/stylesCannotDelete.css" type="text/css" rel="stylesheet">
</head>
<body>
	<!-- Navigation on left side -->
	<jsp:include page="Fragments/navbar.jspf" />	
	<div class="vertical-center back">
		<div class="container">
			<div class="row centered-form center-block animated tada  ">
				<div class="col-md-8 col-md-offset-3  ">
					<div id="pie-chart-widget " class="panel">
            			<div class="panel-heading text-center ">
               				<!-- Text message for user -->
               				<h5 class="text-uppercase  text-danger "><strong>YOU CANNOT DELETE THIS SHOP BECAUSE IT'S ALREADY USED IN PURCHASE</strong></h5>
            			</div><!-- panel-heading text-center -->
               		</div><!-- pie-chart-widget -->
            	</div><!-- col-md-8-offset-3 -->
         	</div><!-- row centered-form center-block animated tada -->	
         </div><!-- container -->
     </div><!-- vertical-center back -->
</body>
</html>