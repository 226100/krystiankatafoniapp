<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Shopping List - Category List</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

	
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
	href="${pageContext.request.contextPath}/Resources/css/stylesCategory.css"
	type="text/css" rel="stylesheet">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.js"></script>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
</head>
<body>
	<link
		href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
		rel="stylesheet">
	<link
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css"
		rel='stylesheet' type='text/css'>

	<jsp:include page="Fragments/navbar.jspf" />
	<div class="vertical-center back">
		<div class="container">
			<div class="row centered-form center-block animated fadeInUp  ">


				<div class="col-md-8 col-md-offset-3  ">

					<div class="panel panel-default panel-table">
						<div class="panel-heading">
							<div class="row">
								<div class="col col-xs-6">
									 <i class="fa fa-shopping-cart"></i><h3 class="panel-title" style="display:inline-block;">&nbsp;&nbsp;&nbsp;All Purchases</h3>
								</div>
								<div class="col col-xs-6 text-right">
									<button type="button" data-toggle="modal" data-target="#new"
										class="btn btn-sm btn-primary btn-create">Create New</button>
								</div>
							</div>
						</div>
						<div class="panel-body">
							<table class="table table-striped table-bordered table-list">
								<thead>
									<tr>
										<th><em class="fa fa-cog"></em></th>
										<th class="hidden-xs">ID</th>
										<th>Name</th>
										<th>Category</th>
										<th>Shop</th>
										<th>Price</th>
										<th>Time</th>
									</tr>
								</thead>
								<tbody>
									<%!int counter = 0;%>
									<c:forEach var="purchaseItem"
										items="${requestScope.purchaseList }">
										<tr>
											<%
												counter++;
											%>
											<td align="center">


												<button type="button" data-toggle="modal"
													data-target="#update"
													data-id="${purchaseItem.id }"
													data-purchasename="${purchaseItem.purchasename }"
													data-categoryname="${purchaseItem.category.categoryname }"
													data-shopname="${purchaseItem.shop.shopname }"
													data-price="${purchaseItem.price }"
													class="btn btn-default">
													<em class="fa fa-pencil"></em>
												</button>
												<form class="special-form"
													id="deleteForm${purchaseItem.id }" action="deletePurchase"
													method="post">
													<input type="hidden" name="purchaseId"
														value="${purchaseItem.id }" /> <a
														onclick="document.getElementById('deleteForm${purchaseItem.id }').submit()"
														class="btn btn-danger"><em class="fa fa-trash"></em></a>
												</form>
											</td>
											<td class="hidden-xs"><%=counter%></td>
											<td><c:out value="${purchaseItem.purchasename }" /></td>
											<td><c:out value="${purchaseItem.category.categoryname }" /></td>
											<td><c:out value="${purchaseItem.shop.shopname }" /></td>
											<td><c:out value="${purchaseItem.price }" /></td>
											<td><c:out value="${purchaseItem.timestamp }" /></td>
										</tr>
									</c:forEach>
									<%
										counter = 0;
									%>
								</tbody>
							</table>

						</div>
						<div class="panel-footer">
							<div class="row">
								<div class="col col-xs-4">Page 1 of 1</div>
								<div class="col col-xs-8">
									<ul class="pagination hidden-xs pull-right">
										<li><a href="#">1</a></li>
									</ul>
									<ul class="pagination visible-xs pull-right">
										<li><a href="#">&laquo;</a></li>
										<li><a href="#">&raquo;</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<div class="fade modal " id="new">
		<div class="modal-dialog modal-lg modal-change">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h2 class="modal-title" id="myModalLabel">Add purchase</h2>
				</div>
				<div class="modal-body">
					<form data-toggle="validator" role="form" id="newpurchase" class="form-horizontal" method="post" action="addPurchase">
						<fieldset>
							<!-- Form Name -->
							<!-- Prepended text-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="prependedtext">Purchase
									name</label>
								<div class="col-md-5">
									<div class="input-group">

										<input id="purchasename" name="purchasename"
											class="form-control" placeholder="Purchase name" type="text" pattern="^[a-zA-Z]+$"
											required autofocus>
											<div class="help-block">Only letters, one word</div>
     										
											
									</div>
									</div>
									</div>		
					      								<div class="form-group">		
									<label class="col-md-4 control-label" for="price">Price</label>
     								<div class="col-md-5">
									<div class="input-group">
      										<input id="price" name="price" pattern="[+]?([0-9]*[.])?[0-9]+" 
											class="form-control" placeholder="Price" type="text"
											required autofocus>
											<div class="help-block">Float, positive number</div>
     										 </div>
									</div>
									</div>
									<div class="form-group">		
									<label class="col-md-4 control-label" for="shop">Select shop</label>
     								<div class="col-md-5">
									<div class="input-group">
     								 <select class="form-control" id="shopname" name="shopname" required>
       								<c:forEach var="shopItem"
										items="${requestScope.shopList }">
       								 <option>${shopItem.shopname }</option>

        							</c:forEach>
      								</select>
      								</div>
									</div>
									</div>
      								
      								<div class="form-group">		
									<label class="col-md-4 control-label" for="categoryname">Select category</label>
     								<div class="col-md-5">
									<div class="input-group">
     								 <select class="form-control" id="categoryname" name = "categoryname" required>
       								<c:forEach var="categoryItem"
										items="${requestScope.categoryList }">
       								 <option>${categoryItem.categoryname }</option>

        							</c:forEach>
      								</select>
      								</div>
									</div>
									</div>

																	<div class="col-md-12 col-md-offset-7">
								<button type="submit" class="btn btn-primary ">
									<i class="fa fa-fw fa-save"></i>Save
								</button>
								</div>
									

							
							<!-- Button -->
						</fieldset>
					</form>
				</div>
			</div>
		</div>
		</div>
	



	<div class="fade modal " id="update">
		<div class="modal-dialog modal-lg modal-change">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h2 class="modal-title" id="myModalLabel">Update name</h2>
				</div>
				<div class="modal-body">
					<form data-toggle="validator" role="form" id="updatepurchase" class="form-horizontal" method="post" action="updatePurchase">
						<fieldset>
							<!-- Form Name -->
							<!-- Prepended text-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="prependedtext">Purchase
									name</label>
								<div class="col-md-5">
									<div class="input-group">

										<input id="purchasename" name="purchasename"
											class="form-control" placeholder="Purchase name" type="text" pattern="^[a-zA-Z]+$"
											required autofocus>
											<div class="help-block">Only letters, one word</div>
     										
											
									</div>
									</div>
									</div>		
					      								<div class="form-group">		
									<label class="col-md-4 control-label" for="price">Price</label>
     								<div class="col-md-5">
									<div class="input-group">
      										<input id="price" name="price" pattern="[+]?([0-9]*[.])?[0-9]+" 
											class="form-control" placeholder="Price" type="text"
											required autofocus>
											<div class="help-block">Float, positive number</div>
     										 </div>
									</div>
									</div>
									<div class="form-group">		
									<label class="col-md-4 control-label" for="shop">Select shop</label>
     								<div class="col-md-5">
									<div class="input-group">
     								 <select class="form-control" id="shopname" name="shopname" required>
       								<c:forEach var="shopItem"
										items="${requestScope.shopList }">
       								 <option>${shopItem.shopname }</option>

        							</c:forEach>
      								</select>
      								</div>
									</div>
									</div>
      								
      								<div class="form-group">		
									<label class="col-md-4 control-label" for="categoryname">Select category</label>
     								<div class="col-md-5">
									<div class="input-group">
     								 <select class="form-control" id="categoryname" name = "categoryname" required>
       								<c:forEach var="categoryItem"
										items="${requestScope.categoryList }">
       								 <option>${categoryItem.categoryname }</option>

        							</c:forEach>
      								</select>
      								</div>
									</div>
									</div>
									<input type="hidden" id="id" name="id" type="text">

																	<div class="col-md-12 col-md-offset-7">
								<button type="submit" class="btn btn-primary ">
									<i class="fa fa-fw fa-save"></i>Save
								</button>
								</div>
									

							
							<!-- Button -->
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script>
		$('#update')
				.on(
						'show.bs.modal',
						function(e) {

							//get data-id attribute of the clicked element
							var id = $(e.relatedTarget).data('id');
							var purchasename = $(e.relatedTarget).data('purchasename');
							var categoryname = $(e.relatedTarget).data(
									'categoryname');
							var shopname = $(e.relatedTarget).data(
							'shopname');
							var price = $(e.relatedTarget).data(
							'price');
							//populate the textbox
							$(e.currentTarget).find('input[name="id"]').val(id);
							$(e.currentTarget).find('input[name="purchasename"]').val(purchasename);
							$(e.currentTarget).find('input[name="price"]').val(price);
							$(e.currentTarget).find('select[name="categoryname"]').val(categoryname);
							$(e.currentTarget).find('select[name="shopname"]').val(shopname);
						});
	</script>

</body>
</html>