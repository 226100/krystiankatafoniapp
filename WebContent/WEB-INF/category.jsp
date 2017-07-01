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
	href="${pageContext.request.contextPath}/Resources/css/stylesCategory.css"
	type="text/css" rel="stylesheet">
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
			<div class="row centered-form center-block  ">


				<div class="col-md-8 col-md-offset-3  ">

					<div class="panel panel-default panel-table">
						<div class="panel-heading">
							<div class="row">
								<div class="col col-xs-6">
									 <i class="fa fa-cubes"></i><h3 class="panel-title" style="display:inline-block;">&nbsp;&nbsp;&nbsp;All Categories</h3>
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
									<c:forEach var="categoryItem"
										items="${requestScope.categoryList }">
										<tr>
											<%
												counter++;
											%>
											<td align="center">


												<button type="button" data-toggle="modal"
													data-target="#update" data-id="${categoryItem.id }"
													data-user-id="${categoryItem.userId }"
													data-categoryname="${categoryItem.categoryname }"
													class="btn btn-default">
													<em class="fa fa-pencil"></em>
												</button>
												<form class="special-form"
													id="deleteForm${categoryItem.id }" action="deleteCategory"
													method="post">
													<input type="hidden" name="categoryId"
														value="${categoryItem.id }" /> <a
														onclick="document.getElementById('deleteForm${categoryItem.id }').submit()"
														class="btn btn-danger"><em class="fa fa-trash"></em></a>
												</form>
											</td>
											<td class="hidden-xs"><%=counter%></td>
											<td><c:out value="${categoryItem.categoryname }" /></td>
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
					<h2 class="modal-title" id="myModalLabel">Add category</h2>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" method="post" action="addCategory">
						<fieldset>
							<!-- Form Name -->
							<!-- Prepended text-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="prependedtext">Category
									name</label>
								<div class="col-md-5">
									<div class="input-group">

										<input id="prependedtext" name="categoryname"
											class="form-control" placeholder="Your category" type="text"
											required autofocus>
									</div>
								</div>


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
					<form class="form-horizontal" method="post" action="updateCategory">
						<input type="hidden" id="id" name="id" type="text" >
						<input type="hidden" id="userId" name="userId" type="text" >
						<fieldset>
							<!-- Form Name -->
							<!-- Prepended text-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="prependedtext">Category
									name</label>
								<div class="col-md-5">
									<div class="input-group">
										<input id="categoryname" name="categoryname"
											class="form-control" placeholder="categoryname" type="text"
											required autofocus>
									</div>
								</div>


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
							var categoryname = $(e.relatedTarget).data(
									'categoryname');
							//populate the textbox
							$(e.currentTarget).find('input[name="id"]').val(id);
							$(e.currentTarget).find('input[name="userId"]')
									.val(userId);
							$(e.currentTarget).find(
									'input[name="categoryname"]').val(
									categoryname);
						});
	</script>
</body>
</html>