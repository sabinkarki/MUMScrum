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
						<h1 class="page-header">${release.getName()}-${release.getVersion()} <small>(${release.getReleaseDate()})</small></h1>
						

					</div>
				</div>
				<!-- /.row -->


				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Release Backlog</h3>
					</div>
					<div class="panel-body">
						<c:choose>
							<c:when test="${ empty releaseBacklog}">
								<div class="alert alert-info" role="alert">No userstories
									added to this release backlog yet.</div>

							</c:when>
							<c:otherwise>
								<ul class="list-group">
									<c:forEach var="userStory" items="${releaseBacklog}">

										<li class="list-group-item">
											<div class="well">
												<p>Story: ${userStory.getTitle()}</p>
												<p>Description: ${userStory.getContent()}</p>
												<p>Date: ${userStory.getCreatedDate()}</p>

											</div>


											<div class="btn-group pull-right" role="group"
												aria-label="...">
													<button type="button"  onclick="window.location.href='<c:url value="/product/${selectedProductId}/release/${release.getId()}/userstory/${userStory.getId()}/remove"/>'" class="btn btn-info">Remove</button>
											</div>
											<div class="clearfix"></div>
										</li>
									</c:forEach>

								</ul>
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