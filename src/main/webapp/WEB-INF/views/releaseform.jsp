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
						<h1 class="page-header">Add Release</h1>

					</div>
				</div>
				<!-- /.row -->


				<div class="row">
					<div class="col-lg-6">

						<form:form role="form" method="POST" modelAttribute="release">

							<div class="form-group">
								<label>Name</label>
								<form:input path="name" class="form-control"
									placeholder="Enter name" />
								<form:errors path="name" cssClass="error" />
							</div>

							<div class="form-group">
								<label>Version</label>
								<form:input path="version" class="form-control"
									placeholder="Enter version" />
								<form:errors path="version" cssClass="error" />
							</div>

							<div class="form-group">
								<label>Release date</label>
								<form:input path="releaseDate" class="form-control"
									placeholder="Enter date" />
								<form:errors path="releaseDate" cssClass="error" />
							</div>

							<c:choose>
								<c:when test="${edit}">
									<button type="submit" class="btn btn-info">Update</button>
								</c:when>
								<c:otherwise>
									<button type="submit" class="btn btn-info">Save</button>

								</c:otherwise>
							</c:choose>


						</form:form>

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