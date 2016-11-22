<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="h"%>
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
					<%-- <div class="col-lg-12">
						<h1 class="page-header">User Stories</h1>

					</div> --%>
				</div>
				<!-- /.row -->


				<div class="row">
					<div class="col-lg-6">

						<div class="table-responsive">
							<table class="table table-hover">
								<h2>Sprints</h2>
								<thead>

									<tr>
										<th>Sprint Title</th>
										<th>Start Date</th>
										<th>End Date</th>
										<th>Delete</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach var="sprint" items="${sprints}">
										
										<tr>
											<td><a href="${pageContext.request.contextPath}/sprint/${sprint.getId()}/update">${sprint.getTitle()}</a></td>
											<td><a href="${pageContext.request.contextPath}/sprint/${sprint.getId()}/update">${sprint.getStartDate()}</a></td>
											<td><a href="${pageContext.request.contextPath}/sprint/${sprint.getId()}/update">${sprint.getEndDate()}</a></td>
											<td><a href="${pageContext.request.contextPath}/sprint/${sprint.getId()}/delete"> <span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
										
										</tr>
										
									</c:forEach>




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
