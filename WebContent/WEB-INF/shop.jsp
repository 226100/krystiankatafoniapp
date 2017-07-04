<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Shopping List - Shop List</title>

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
									<i class="fa fa-home"></i><h3 class="panel-title" style="display:inline-block;">&nbsp;&nbsp;&nbsp;All Shops</h3>
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
									</tr>
								</thead>
								<tbody>
									<%!int counter = 0;%>
									<c:forEach var="shopItem" items="${requestScope.shopList }">
										<tr>
											<%
												counter++;
											%>
											<td align="center">
												<button type="button" data-toggle="modal"
													data-target="#update" data-id="${shopItem.id }"
													data-user-id="${shopItem.userId }"
													data-shopname="${shopItem.shopname }"
													class="btn btn-default">
													<em class="fa fa-pencil"></em>
												</button>
												<form class="special-form" id="deleteForm${shopItem.id }"
													action="deleteShop" method="post">
													<input type="hidden" name="shopId"
														value="${shopItem.id }" /> <a
														onclick="document.getElementById('deleteForm${shopItem.id }').submit()"
														class="btn btn-danger"><em class="fa fa-trash"></em></a>
												</form>
											</td>
											<td class="hidden-xs"><%=counter%></td>
											<td><c:out value="${shopItem.shopname }" /></td>
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
					<h2 class="modal-title" id="myModalLabel">Add Shop</h2>
				</div>
				<div class="modal-body">
					<form data-toggle="validator" role="form" id="newshop" class="form-horizontal" method="post" action="addShop">
						<fieldset>

							<div class="form-group">
								<label class="col-md-4 control-label" for="prependedtext">Shop
									name</label>
								<div class="col-md-5">
									<div class="input-group">

										<input id="shopname" name="shopname"
											class="form-control" placeholder="Your shop" type="text" pattern="^[a-zA-Z]+$"
											required autofocus>
											<div class="help-block">Only letters, one word</div>
									</div>
								</div>
								</div>
								<div class="col-md-12 col-md-offset-7">
								<button type="submit" class="btn btn-primary">
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
					<form data-toggle="validator" role="form" id="updateshop" class="form-horizontal" method="post" action="updateShop">

						<fieldset>
							<!-- Form Name -->
							<!-- Prepended text-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="prependedtext">Shop
									name</label>
								<div class="col-md-5">
									<div class="input-group">
										<input id="shopname" name="shopname"
											class="form-control" placeholder="shopname" type="text" pattern="^[a-zA-Z]+$"
											required autofocus>
											<div class="help-block">Only letters, one word</div>
									</div>
								</div>
								</div>
						<input type="hidden" id="id" name="id" type="text"> 
						<input type="hidden" id="userId" name="userId" type="text">
								<div class="col-md-12 col-md-offset-7">
								<button type="submit" class="btn btn-primary">
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
							var userId = $(e.relatedTarget).data('user-id');
							var shopname = $(e.relatedTarget).data(
									'shopname');
							//populate the textbox
							$(e.currentTarget).find('input[name="id"]').val(id);
							$(e.currentTarget).find('input[name="userId"]')
									.val(userId);
							$(e.currentTarget).find(
									'input[name="shopname"]').val(
									shopname);
						});
	</script>

</body>
</html>