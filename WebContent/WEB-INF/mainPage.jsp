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

</head>
<body>
	<link
		href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
		rel="stylesheet">

	<jsp:include page="Fragments/navbar.jspf" />
<div class="vertical-center back">
		<div class="container">
			<div class="row centered-form center-block  ">


				<div class="col-md-8 col-md-offset-3  ">

					<div class="panel panel-default panel-table">
						<div class="panel-heading">
							<div class="row">
								<div class="col col-xs-6">
									 <i class="fa fa-cubes"></i><h3 class="panel-title" style="display:inline-block;">&nbsp;&nbsp;&nbsp;Test</h3>
								</div>
								<div class="col col-xs-6 text-right">
									<button type="button" data-toggle="modal" data-target=""
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


		

</body>
</html>