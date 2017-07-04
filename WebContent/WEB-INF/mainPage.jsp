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
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/Resources/js/custom.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<link
	href="${pageContext.request.contextPath}/Resources/css/stylesInterface.css"
	type="text/css" rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/Resources/css/stylesMainPage.css"
	type="text/css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
<style>
/*-- BS3 Modified Classes --*/
.panel {
    border: none;
    box-shadow: 0 1px 1px rgba(0, 0, 0, 0.25);
    border-radius: 5px;
}
.panel-body {
    padding: 20px;
}
.panel-heading {
    border-top-left-radius: 5px;
    border-top-right-radius: 5px;
}
.panel-footer {
    border-bottom-right-radius: 5px;
    border-bottom-left-radius: 5px;
}




/*-- Common Use Classes --*/
.btn-ui {
    background-color: #E55F3A;
    border-color: #C54A28;
    color: #fff;
}
.btn-ui:hover {
    background-color: #E0624C;
    color: #fff;
}
.list-block {
    display: table;
    width: 100%;
    border-collapse: collapse;
    border: none;
}
.list-block ul {
    display: table-row;
}
.list-block li {
    display: table-cell;
    margin: 0;
}
.pad-left-0 {
    padding-left: 0px;
}
.pad-right-0 {
    padding-right: 0px;
}
.mrg-btm-10 {
    margin-bottom: 10px;
}
.mrg-btm-20 {
    margin-bottom: 20px;
}





/*-- Pie Chart Widget --*/
#pie-chart-widget .panel-body {
    padding: 0px;
}
#pie-chart-widget .panel-footer {
    background-color: #fff;
    padding: 0px;
    margin-top: 20px;
}
#pie-chart-widget .panel-footer .btn {
    border: none;
    border-top-left-radius: 0px;
    border-top-right-radius: 0px;
    padding: 20px 0px;
    color: #fff;
    background-color: #776B5F;
    border-top: 3px solid #6d6257;
}
#pie-chart-widget .panel-footer .btn:hover {
    background-color: #62584C;
    border-color: #52483F;
}
#pie-chart-widget h2 {
    font-weight: 700;
    margin: 3px 0 0 0;
}
#pie-chart-widget .legend li {
    background-color: #F5F0EC;
    padding: 20px 10px;
}
#pie-chart-widget .legend li:not(:first-child) {
    border-left: 1px solid #fff;
}
#pie-chart-widget .legend .purchase {   
    border-top: 4px solid #4DAF7C; 
}
#pie-chart-widget .legend .price {
    border-top: 4px solid #EAC85D;
}
#pie-chart-widget .legend .shop {
    border-top: 4px solid #5d84ea;
}
#pie-chart-widget .legend .category {
    border-top: 4px solid #E25331;
}






    
</style>
</head>
<body>
	<link
		href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
		rel="stylesheet">

	<jsp:include page="Fragments/navbar.jspf" />
		
	<div class="vertical-center back">
		<div class="container">
			<div class="row centered-form center-block animated rollIn  ">
			<div class="col-md-8 col-md-offset-3  ">
		<div id="pie-chart-widget" class="panel">
            <div class="panel-heading text-center ">
               <h5 class="text-uppercase animated zoomInDown "><strong>General Informations</strong></h5>
            </div>

            <div class="panel-footer">
               <div class="list-block">
                  <ul class="text-center legend">
                     <li class="purchase animated zoomInDown" style="margin-right: 1px;">
                        Amount of Purchases 
                        <h2><c:out value="${requestScope.amountOfAllPurchases}" /></h2>
                     </li>
                     <li class="shop animated zoomInDown">
                        Amount of Shops 
                        <h2><c:out value="${requestScope.amountOfAllShops}" /></h2>
                     </li>
                     <li class="category animated zoomInDown" style="margin-left: 1px;">
                        Amount of Categories 
                        <h2><c:out value="${requestScope.amountOfAllCategories}" /></h2>
                     </li>
                     <li class="price animated zoomInDown" style="margin-left: 1px;">
                        Total price 
                        <h2><c:out value="${requestScope.sumOfPrices}" /></h2>
                     </li>
                  </ul>
               </div>
               <div class="btn-group btn-group-justified text-uppercase text-center">
                  <a href="statistics" class="btn btn-default animated zoomInDown" role="button"><i class="fa fa-area-chart fa-2x"></i><br><small>Go to statistics</small></a>

               </div>
               </div>
            </div>
         </div>	
         </div>
        </div></div>
	


		

</body>
</html>