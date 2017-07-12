<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Shopping List - Main Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- External import for bootsrap, jquery,animation -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<!-- Css styles for mainPage -->
<link href="${pageContext.request.contextPath}/Resources/css/stylesInterface.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/Resources/css/stylesMainPage.css" type="text/css" rel="stylesheet">
</head>

<body>
	<!-- Navigation on the right side -->
	<jsp:include page="Fragments/navbar.jspf" />
	<!-- Central main container -->	
	<div class="vertical-center back">
		<div class="container middle-container">
		<!-- Animation rollIn -->
			<div class="row centered-form center-block animated rollIn ">
				<div class="col-md-7 col-md-offset-3  ">
				<!-- There is use look of pie-chart-widget window to show general informations -->
					<div id="pie-chart-widget" class="panel">
            			<div class="panel-heading text-center ">
            				<!-- Caption animated zoomInDown -->
               				<h5 class="text-uppercase animated zoomInDown "><strong>General Informations</strong></h5>
            			</div><!-- .panel-heading .text-center -->
						<div class="panel-footer">
               				<div class="list-block">
               					<!-- List - general informations about shops, categories, purchases and prices -->
                  				<ul class="text-center legend">
                     				<li class="purchase animated zoomInDown" style="margin-right: 1px;">
                        				Amount of Purchases<h2><c:out value="${requestScope.amountOfAllPurchases}" /></h2>
                     				</li><!-- .purchase .animated .zoomInDown -->
                     				<li class="shop animated zoomInDown">
                        				Amount of Shops <h2><c:out value="${requestScope.amountOfAllShops}" /></h2>
                     				</li><!-- .shop .animated .zoomInDown -->
                     				<li class="category animated zoomInDown" style="margin-left: 1px;">
                        				Amount of Categories <h2><c:out value="${requestScope.amountOfAllCategories}" /></h2>
                     				</li><!-- .category .animated .zoomInDown -->
                     				<li class="price animated zoomInDown" style="margin-left: 1px;">
                        				Total price <h2><c:out value="${requestScope.sumOfPrices}" /></h2>
                     				</li><!-- .price .animated .zoomInDown -->
                  				</ul><!-- .text-center .legend -->
               				</div><!-- .list-block -->
               				<div class="btn-group btn-group-justified text-uppercase text-center">
                  				<a href="statistics" class="btn btn-default animated zoomInDown" role="button">
                  					<i class="fa fa-area-chart fa-2x"></i><br><small>Go to statistics</small>
                  				</a><!-- .btn .btn-default .animated . zoomInDown -->
                  			</div><!-- .btn-group .btn-group-justified .text-uppercase .text-center -->
              			 </div><!-- .panel-footer -->
            		</div><!-- .pie-chart-widget -->
         		</div><!-- .col-md-7 .col-md-offset-3 -->	
         	</div><!-- .row .centered-form .center-block .animated .rollIn -->
        </div><!-- .container .middle-container -->
	</div><!-- .vertical-center .back -->
</body>
</html>