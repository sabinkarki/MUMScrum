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
						<h1 class="page-header">Releases</h1>

					</div>
				</div>
				<!-- /.row -->


				<div class="row">
					<div class="col-lg-12">

						<div class="table-responsive">
							<c:choose>
								<c:when test="${ empty product.getReleaseList()}">
									<div class="alert alert-info" role="alert">
										No releases added yet. <a
											href="<c:url value='/product/${selectedProductId}/release/new' />">Add
											new release </a>
									</div>

								</c:when>
								<c:otherwise>
									
									<button type="button" style="margin-bottom:10px" class="btn btn-info pull-left" onclick="window.location.href='<c:url value="/product/${selectedProductId}/release/new'"/>">Add new release</button>
									<div class="clearfix"></div>
									

									<c:forEach var="release" items="${product.getReleaseList()}">

										<div class="panel panel-default">
											<div class="panel-heading">${release.getName()}</div>
											<div class="panel-body">
													<p> Version: ${release.getVersion()}</p>
													<p> Release date: ${release.getReleaseDate()}</p>


												<div class="btn-group pull-right" role="group" aria-label="...">
													<button type="button" onclick="window.location.href='<c:url value="/product/${selectedProductId}/move/release/${release.getId()}"/>'" class="btn btn-info">Create Release Backlog</button>
													<button type="button" onclick="window.location.href='<c:url value="/releasebacklog/product/${selectedProductId}/release/${release.getId()}"/>'" class="btn btn-info">View Release Backlog</button>
													<button type="button" class="btn btn-info">Add Sprints</button>
													<button type="button"  onclick="window.location.href='<c:url value="/product/${selectedProductId}/release/${release.getId()}/update"/>'" class="btn btn-info">Edit</button>
													<button type="button"  onclick="window.location.href='<c:url value="/product/${selectedProductId}/release/${release.getId()}/delete"/>'" class="btn btn-info">Delete</button>
												</div>

											</div>
										</div>
									</c:forEach>
								</c:otherwise>
							</c:choose>

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