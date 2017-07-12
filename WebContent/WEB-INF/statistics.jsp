<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Shopping List - Statistics</title>
<!--External imports for charts and animations  -->
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<!--Bootstrap import  -->
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
<!--Css styles for statistic jsp page  -->
<link href="${pageContext.request.contextPath}/Resources/css/stylesInterface.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/Resources/css/stylesStatistic.css" type="text/css" rel="stylesheet">
	    
<!-- Script which is responsible for showing charts in jsp page, first chart is shopChart and second is categoryChart  -->
<script type="text/javascript">
window.onload = function () {
	var shopChart = new CanvasJS.Chart("shops",
			{
		title:{
			text: "Which shop do you prefer?",
			fontSize: 20
		},
                animationEnabled: true,
		legend:{
			verticalAlign: "center",
			horizontalAlign: "left",
			fontSize: 18,
			fontFamily: "Helvetica"        
		},
		theme: "theme2",
		data: [
		{        
			type: "pie",       
			indexLabelFontFamily: "Garamond",       
			indexLabelFontSize: 14,
			indexLabel: "{label} {y}%",
			startAngle:-20,      
			showInLegend: true,
			toolTipContent:"{legendText} {y}%",
			dataPoints: [
				<c:forEach var="shopItem" items="${requestScope.occShopList }">
					{  y: "${shopItem.getPercent() }", legendText:"${shopItem.getShop().getShopname() }", label: "${shopItem.getShop().getShopname() }" },
				</c:forEach>
			]
		}
		]
	});
	var categoryChart = new CanvasJS.Chart("categories",
			{
		title:{
			text: "Which category is your favourite?",
			fontSize: 20
		},
                animationEnabled: true,
		legend:{
			verticalAlign: "center",
			horizontalAlign: "left",
			fontSize: 18,
			fontFamily: "Helvetica"        
		},
		theme: "theme2",
		data: [
		{        
			type: "pie",       
			indexLabelFontFamily: "Garamond",       
			indexLabelFontSize: 14,
			indexLabel: "{label} {y}%",
			startAngle:-20,      
			showInLegend: true,
			toolTipContent:"{legendText} {y}%",
			dataPoints: [
					<c:forEach var="categoryItem" items="${requestScope.occCategoryList }">
						{  y: "${categoryItem.getPercent() }", legendText:"${categoryItem.getCategory().getCategoryname() }",
						label: "${categoryItem.getCategory().getCategoryname() }" },	
					</c:forEach>
			]
		}
		]
	});
	shopChart.render();
	categoryChart.render();
}
</script><!-- End of script responsible for charts -->
</head>
<body>
	<!--Navigation on right side  -->
	<jsp:include page="Fragments/navbar.jspf" />
	<!--Center container for charts -->		
	<div class="vertical-center back">
		<div class="container middle-container">
			<!-- Animation for block -->
			<div class="row centered-form center-block animated rollIn  ">
				<div class="col-sm-2 col-md-8 col-md-offset-3  ">
					<div id="pie-chart-widget" class="panel">
            			<div class="panel-heading text-center ">
               				<h5 class="text-uppercase animated zoomInDown "><strong>GENERAL STATISTICS</strong></h5>
            			</div>
            			<div class="panel-footer">
               				<div class="list-block">
               					<!-- Pie chart for shops --> 
                 				<div id="shops" style="height: 300px; width: 50%;display:inline;float:left;"></div> 
               					<!-- Pie chart for categories -->
                			 	<div id="categories" style="height: 300px; width: 50%;display:inline;float:left;"></div> 

               				</div><!--list-block  -->
               			</div><!--panel-footer  -->
            		</div><!--pie-chart-widget  -->            
         		</div><!--col-md-10 col-md-offset-2  -->	
         	</div><!--row centered-form center-block animated rollIn  -->
        </div><!--container  -->
	</div><!--vertical-center back  -->
</body>
</html>