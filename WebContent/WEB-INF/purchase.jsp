<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Shopping List - Purchase List</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- External import for bootsrap, jquery, validator, animation -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet' type='text/css'>
<!-- Css styles for category page -->
<link href="${pageContext.request.contextPath}/Resources/css/stylesInterface.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/Resources/css/stylesPurchase.css" type="text/css" rel="stylesheet">

</head>

<body>
	<!-- Navigation on the right side -->
	<jsp:include page="Fragments/navbar.jspf" />
	<!-- Central main container -->
	<div class="vertical-center back">
		<div class="container middle-container">
			<div class="row centered-form center-block animated fadeInUp  ">
				<div class="col-md-6 col-md-offset-3 ">
					<div class="panel panel-default panel-table">
						<div class="panel-heading">
							<div class="row">
								<div class="col col-xs-6">
									<!-- Main title for table -->
									<i class="fa fa-shopping-cart"></i><h3 class="panel-title" style="display:inline-block;">&nbsp;&nbsp;&nbsp;All Purchases</h3>
								</div><!-- col col-xs-6 -->
								<!-- Button "create new", open a modal to put information about new category -->
								<div class="col col-xs-6 text-right">
									<button type="button" data-toggle="modal" data-target="#new"
									class="btn btn-sm btn-primary btn-create">Create New</button>
								</div><!-- col col-xs-6 text-right -->
							</div><!-- row -->
						</div><!-- panel-heading -->
						<!-- Main table -->
						<div class="panel-body">
							<table class="table table-striped table-bordered table-list">
								<!-- Table headers -->
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
								<!-- Table body -->
								<tbody>
									<!-- Counter for id of each element in row, this is not purchase_id from database, only id on page(for table) -->
									<%!int counter = 0;%>
									<!-- Make a row in table for each element from purchaseList, loop -->
									<c:forEach var="purchaseItem" items="${requestScope.purchaseList }">
										<tr>
											<!-- Increment of counter, because next row in table is made -->
											<% counter++; %>
											<td align="center">
												<!-- Button "update" for update one purchase, data is send to modal through javascript -->
												<button type="button" data-toggle="modal"
													data-target="#update"
													data-id="${purchaseItem.id }"
													data-purchasename="${purchaseItem.purchasename }"
													data-categoryname="${purchaseItem.category.categoryname }"
													data-shopname="${purchaseItem.shop.shopname }"
													data-price="${purchaseItem.price }"
													class="btn btn-default">
													<em class="fa fa-pencil"></em><!-- Pencil glyphicon -->
												</button><!-- end of update button  -->
												<!-- Form "deletePurchase" for delete one purchase  -->
												<form class="special-form" id="deleteForm${purchaseItem.id }" action="deletePurchase" method="post">
													<!-- Input for purchase id, hidden -->
													<input type="hidden" name="purchaseId" value="${purchaseItem.id }" /> 
													<!-- Link to submit form and send data to deletePurchase controller -->
													<a onclick="document.getElementById('deleteForm${purchaseItem.id }').submit()"
													class="btn btn-danger">
														<!-- Trash glyphicon -->
														<em class="fa fa-trash"></em>
													</a><!-- btn btn-danger -->
												</form><!-- special form -->
											</td><!-- End of first column -->
											<td class="hidden-xs"><%=counter%></td><!-- End of second column(counter for each row) -->
											<td><c:out value="${purchaseItem.purchasename }" /></td><!-- End of third column(purchasename) -->
											<td><c:out value="${purchaseItem.category.categoryname }" /></td><!-- End of fourth column(categoryname) -->
											<td><c:out value="${purchaseItem.shop.shopname }" /></td><!-- End of fifth column(shopname) -->
											<td><c:out value="${purchaseItem.price }" /></td><!-- End of sixth column(price) -->
											<td><c:out value="${purchaseItem.timestamp }" /></td><!-- End of seventh column(timestamp) -->
										</tr><!-- Row end -->
									</c:forEach><!-- Loop end -->
									<!-- Reset counter to value 0 -->
									<% counter = 0; %>
								</tbody><!-- End of table body -->
							</table><!-- table table-striped table-bordered table-list -->
						</div><!--  panel-body -->
						<!-- Footer for table -->
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
								</div><!-- col col-xs-8 -->
							</div><!-- row -->
						</div><!-- panel-footer -->
					</div><!-- panel panel-default panel-table -->
				</div><!-- col-md-8 col-md-offset-3 -->
			</div><!-- row centered-form center-block animated fadeInUp -->
		</div><!-- container -->
	</div><!-- vertical-center back -->
	
	<!-- Modal window for creating new purchase -->
	<div class="fade modal " id="new">
		<div class="modal-dialog modal-lg modal-change">
			<div class="modal-content">
				<div class="modal-header">
					<!-- Close button for modal -->
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<!-- Label for modal -->
					<h2 class="modal-title" id="myModalLabel">Add purchase</h2>
				</div><!-- modal-header -->
				<div class="modal-body">
					<!-- Form for input new purchase, additional function is validator from validator.js script, data is send to addPurchase controller  -->
					<form data-toggle="validator" role="form" id="newpurchase" class="form-horizontal" method="post" action="addPurchase">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label" for="prependedtext">Purchase name</label>
								<div class="col-md-5">
									<div class="input-group">
										<!-- Input for purchase name, which has to match a pattern -->
										<input id="purchasename" name="purchasename"
										class="form-control" placeholder="Purchase name" type="text" pattern="^[a-zA-Z]+$"
										required autofocus>
										<div class="help-block">Only letters, one word</div>		
									</div><!-- input-group -->
								</div><!-- col-md-5 -->
							</div>	<!-- form-group -->	
					      	<div class="form-group">		
								<label class="col-md-4 control-label" for="price">Price</label>
     							<div class="col-md-5">
									<div class="input-group">
										<!-- Input for price, which has to match a pattern -->
      									<input id="price" name="price" pattern="[+]?([0-9]*[.])?[0-9]+" 
										class="form-control" placeholder="Price" type="text"
										required autofocus>
										<div class="help-block">Float, positive number</div>
     								</div><!-- input-group -->
								</div><!-- col-md-5 -->
							</div><!-- form-group -->	
							<div class="form-group">		
								<label class="col-md-4 control-label" for="shop">Select shop</label>
     							<div class="col-md-5">
									<div class="input-group">
									<!-- List for shops from shopList, we can choose only one shop for one purchase -->
     									<select class="form-control" id="shopname" name="shopname" required>
       										<c:forEach var="shopItem" items="${requestScope.shopList }">
       								 			<option>${shopItem.shopname }</option>
											</c:forEach>
      									</select><!-- form-control -->
      								</div><!-- input-group -->
								</div><!-- col-md-5 -->
							</div><!-- form-group -->
      						<div class="form-group">		
								<label class="col-md-4 control-label" for="categoryname">Select category</label>
     							<div class="col-md-5">
									<div class="input-group">
										<!-- List for categories from categoryList, we can choose only one category for one purchase -->
     								 	<select class="form-control" id="categoryname" name = "categoryname" required>
       										<c:forEach var="categoryItem" items="${requestScope.categoryList }">
       								 			<option>${categoryItem.categoryname }</option>
											</c:forEach>
      									</select><!-- form-control -->
      								</div><!-- input-group -->
								</div><!-- col-md-5 -->
							</div><!-- form-group -->
							<div class="col-md-12 col-md-offset-7">
								<button type="submit" class="btn btn-primary ">
									<i class="fa fa-fw fa-save"></i>Save
								</button><!-- Submit button for form -->
							</div><!-- col-md-12 col-md-offset-7 -->
						</fieldset>
					</form><!-- form-horizontal, End of form -->
				</div><!-- modal-body -->
			</div><!-- modal-content -->
		</div><!-- modal-dialog modal-lg modal-change -->
	</div><!-- fade modal, End of modal window -->
	
	<!-- Modal window for update purchase -->
	<div class="fade modal " id="update">
		<div class="modal-dialog modal-lg modal-change">
			<div class="modal-content">
				<div class="modal-header">
					<!-- Close button for modal -->
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<!-- Label for modal -->
					<h2 class="modal-title" id="myModalLabel">Update name</h2>
				</div><!-- modal-header -->
				<div class="modal-body">
					<!-- Form for update purchase, additional function is validator from validator.js script, data is send to updatePurchase controller  -->
					<form data-toggle="validator" role="form" id="updatepurchase" class="form-horizontal" method="post" action="updatePurchase">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label" for="prependedtext">Purchasename</label>
								<div class="col-md-5">
									<div class="input-group">
										<!-- Hidden input with id(id from database) of purchase -->
										<input type="hidden" id="id" name="id" type="text">
										<!-- Input for purchase name, which has to match a pattern -->
										<input id="purchasename" name="purchasename"
										class="form-control" placeholder="Purchase name" type="text" pattern="^[a-zA-Z]+$"
										required autofocus>
										<div class="help-block">Only letters, one word</div>	
									</div><!-- input-group -->
								</div><!-- col-md-5 -->
							</div><!-- form-group -->
					      	<div class="form-group">		
								<label class="col-md-4 control-label" for="price">Price</label>
     							<div class="col-md-5">
									<div class="input-group">
											<!-- Input for price, which has to match a pattern -->
      										<input id="price" name="price" pattern="[+]?([0-9]*[.])?[0-9]+" 
											class="form-control" placeholder="Price" type="text"
											required autofocus>
											<div class="help-block">Float, positive number</div>
									</div><!-- input-group -->
								</div><!-- col-md-5 -->
							</div><!-- form-group -->
							<div class="form-group">		
								<label class="col-md-4 control-label" for="shop">Select shop</label>
     							<div class="col-md-5">
									<div class="input-group">
									<!-- List for shops from shopList, we can choose only one shop for one purchase -->
     									<select class="form-control" id="shopname" name="shopname" required>
       										<c:forEach var="shopItem" items="${requestScope.shopList }">
       								 			<option>${shopItem.shopname }</option>
											</c:forEach>
      									</select>
									</div><!-- input-group -->
								</div><!-- col-md-5 -->
							</div><!-- form-group -->
      						<div class="form-group">		
								<label class="col-md-4 control-label" for="categoryname">Select category</label>
     							<div class="col-md-5">
									<div class="input-group">
										<!-- List for categories from categoryList, we can choose only one category for one purchase -->
     									<select class="form-control" id="categoryname" name = "categoryname" required>
       										<c:forEach var="categoryItem" items="${requestScope.categoryList }">
       								 			<option>${categoryItem.categoryname }</option>
											</c:forEach>
      									</select>
									</div><!-- input-group -->
								</div><!-- col-md-5 -->
							</div><!-- form-group -->
							<div class="col-md-12 col-md-offset-7">
								<button type="submit" class="btn btn-primary ">
									<i class="fa fa-fw fa-save"></i>Save
								</button><!-- Submit button for form -->
							</div><!-- col-md-12 col-md-offset-7 -->
						</fieldset>
					</form><!-- form-horizontal, End of form -->
				</div><!-- modal-body -->
			</div><!-- modal-content -->
		</div><!-- modal-dialog modal-lg modal-change -->
	</div><!-- fade modal, End of modal window -->
	<!-- Js script for copy data to modal window(Update window) -->
<script>
	$('#update')
	.on('show.bs.modal',function(e) {
		//get data-id attribute of the clicked element
		var id = $(e.relatedTarget).data('id');
		var purchasename = $(e.relatedTarget).data('purchasename');
		var categoryname = $(e.relatedTarget).data('categoryname');
		var shopname = $(e.relatedTarget).data('shopname');
		var price = $(e.relatedTarget).data('price');
		//populate the textbox and set value in lists
		$(e.currentTarget).find('input[name="id"]').val(id);
		$(e.currentTarget).find('input[name="purchasename"]').val(purchasename);
		$(e.currentTarget).find('input[name="price"]').val(price);
		$(e.currentTarget).find('select[name="categoryname"]').val(categoryname);
		$(e.currentTarget).find('select[name="shopname"]').val(shopname);
	});
</script>
</body>
</html>