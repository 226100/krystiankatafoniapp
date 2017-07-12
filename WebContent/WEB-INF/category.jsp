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
<link href="${pageContext.request.contextPath}/Resources/css/stylesCategory.css" type="text/css" rel="stylesheet">
<!-- Js script for copy data to modal window(Update window) -->
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/js/categoryUpdateScript.js"></script>
</head>

<body>
	<!-- Navigation on the right side -->
	<jsp:include page="Fragments/navbar.jspf" />
	<!-- Central main container -->
	<div class="vertical-center back">
		<div class="container middle-container">
			<div class="row centered-form center-block animated fadeInUp  ">
				<div class="col-md-4 col-md-offset-4  ">
					<div class="panel panel-default panel-table">
						<div class="panel-heading">
							<div class="row">
								<div class="col col-xs-6">
									<!-- Main title for table -->
									<i class="fa fa-cubes"></i><h3 class="panel-title" style="display:inline-block;">&nbsp;&nbsp;&nbsp;All Categories</h3>
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
								<thead>
									<tr>
										<th><em class="fa fa-cog"></em></th>
										<th class="hidden-xs">ID</th>
										<th>Name</th>
									</tr>
								</thead>
								<tbody>
									<!-- Counter for id of each element in row, this is not category_id from database, only id on page(for table) -->
									<%!int counter = 0;%>
									<!-- Make a row in table for each element from categoryList, loop -->
									<c:forEach var="categoryItem"
										items="${requestScope.categoryList }">
										<tr>
											<!-- Increment of counter, because next row in table is made -->
											<%counter++;%>
											<td align="center">
												<!-- Button "update" for update one category, data is send to modal through javascript -->
												<button type="button" data-toggle="modal"
												data-target="#update" data-id="${categoryItem.id }"
												data-user-id="${categoryItem.userId }"
												data-categoryname="${categoryItem.categoryname }"
												class="btn btn-default">
													<em class="fa fa-pencil"></em><!-- Pencil glyphicon -->
												</button><!-- end of update button  -->
												<!-- Form "deleteCategory" for delete one category,  -->
												<form class="special-form"
												id="deleteForm${categoryItem.id }" action="deleteCategory"
												method="post">
													<!-- Input for category id, hidden -->
													<input type="hidden" name="categoryId" value="${categoryItem.id }" /> 
													<!-- Link to submit form and send data to deleteCategory controller -->
													<a onclick="document.getElementById('deleteForm${categoryItem.id }').submit()"
													class="btn btn-danger">
														<em class="fa fa-trash"></em><!-- Trash glyphicon -->
													</a><!-- btn btn-danger -->
												</form><!-- special-form -->
											</td><!-- End of first column -->
											<td class="hidden-xs"><%=counter%></td><!-- End of second column(counter for each row) -->
											<td><c:out value="${categoryItem.categoryname }" /></td><!-- End of third column(categoryname) -->
										</tr><!-- Row end -->
									</c:forEach><!-- Loop end -->
									<!-- Reset counter to value 0 -->
									<%counter = 0;%>
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
	
	<!-- Modal window for creating new category -->
	<div class="fade modal " id="new">
		<div class="modal-dialog modal-lg modal-change">
			<div class="modal-content">
				<div class="modal-header">
					<!-- Close button for modal -->
					<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
					<!-- Label for modal -->
					<h2 class="modal-title" id="myModalLabel">Add category</h2>
				</div><!-- modal-header -->
				<div class="modal-body">
					<!-- Form for input new category, additional function is validator from validator.js script, data is send to addCategory controller  -->
					<form data-toggle="validator" role="form" class="form-horizontal" method="post" action="addCategory">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label" for="prependedtext">Categoryname</label>
								<div class="col-md-5">
									<div class="input-group">
										<!-- Input for category name, which has to match a pattern -->
										<input id="prependedtext" name="categoryname"
										class="form-control" placeholder="Your category" type="text" pattern="^[a-zA-Z]+$"
										required autofocus>
										<div class="help-block">Only letters, one word</div>
									</div><!-- input-group -->
								</div><!-- col-md-5 -->
							</div><!-- form-group -->
							<div class="col-md-12 col-md-offset-7">
								<!-- Submit button for form -->
								<button type="submit" class="btn btn-primary">
									<i class="fa fa-fw fa-save"></i>Save
								</button>
							</div><!-- col-md-12-offset-7 -->
						</fieldset>
					</form><!-- form-horizontal, End of form -->
				</div><!-- modal-body -->
			</div><!-- modal-content -->
		</div><!-- modal-dialog modal-lg modal-change -->
	</div><!-- fade modal, End of modal window -->


	<!-- Modal window for updating new category -->
	<div class="fade modal " id="update">
		<div class="modal-dialog modal-lg modal-change">
			<div class="modal-content">
				<div class="modal-header">
					<!-- Close button for modal -->
					<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
					<h2 class="modal-title" id="myModalLabel">Update name</h2>
				</div><!-- modal-header -->
				<div class="modal-body">
					<!-- Form for update category, additional function is validator from validator.js script, data is send to updateCategory controller  -->
					<form data-toggle="validator" role="form" class="form-horizontal" method="post" action="updateCategory">
						<!-- Hidden input with id(id from database) of category -->
						<input type="hidden" id="id" name="id" type="text" >
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label" for="prependedtext">Categoryname</label>
								<div class="col-md-5">
									<div class="input-group">
										<!-- Input for category name, which has to match a pattern -->
										<input id="categoryname" name="categoryname"
										class="form-control" placeholder="categoryname" type="text" pattern="^[a-zA-Z]+$"
										required autofocus>
										<div class="help-block">Only letters, one word</div>
									</div><!-- input-group -->
								</div><!-- col-md-5 -->
							</div><!-- form-group -->
							<div class="col-md-12 col-md-offset-7">
								<!-- Submit button for form -->
								<button type="submit" class="btn btn-primary">
								<i class="fa fa-fw fa-save"></i>Save
								</button>
							</div>
						</fieldset>
					</form><!-- form-horizontal, End of form -->
				</div><!-- modal-body -->
			</div><!-- modal-content -->
		</div><!-- modal-dialog modal-lg modal-change -->
	</div><!-- fade modal, End of modal window -->
</body>
</html>