<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<h:header />
</head>
<body>
	<div id="wrapper">

		<h:sidebar />

		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">
							Dashboard <small>Add Product</small>
						</h1>

					</div>
				</div>
				<!-- /.row -->


				<div class="row">
					<div class="col-lg-6">

						<div class="table-responsive">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>Name</th>
										<th>StartDate</th>
										<th>Actions</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>${product.getName()}</td>
										<td>${product.getStartDate()}</td>
										<td>
										<c:out value="${product.getReleaseList()}" ></c:out>
										</td>
									</tr>
									
									
								</tbody>
							</table>
						</div>

					</div>
				</div>
				<!-- /.row -->


			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- /#page-wrapper -->

	</div>


	<h:footer />
</body>
</html>