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
	<h:nosidebar />

	<div id="page-wrapper">

		<div class="container-fluid">

			<!-- Page Heading -->
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Add UserStory</h1>

				</div>
			</div>
			<!-- /.row -->


			<div class="row">
				<div class="col-lg-6">

					<form:form role="form" method="POST" modelAttribute="userStory">
					<form:hidden path="productId" />

						
						<div class="form-group">
							<label>Title</label>
							<form:input path="title" class="form-control"
								placeholder="Enter title" />
							<form:errors path="title" cssClass="error" />
						</div>
						
							<div class="form-group">
							<label>Content</label>
							<form:textarea path="content" class="form-control"
								placeholder="Enter content" />
							<form:errors path="content" cssClass="error" />
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



	<h:footer />
</body>
</html>