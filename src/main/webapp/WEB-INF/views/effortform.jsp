<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<h:header />
</head>
<body>
	<div id="wrapper">
		<div id="page-wrapper">
			<div class="container-fluid">
				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Add/Edit Effort</h1>
					</div>
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-6">
						<form:form role="form" method="POST" modelAttribute="userstory" id="userstory" action="updateUserStory">
							<div class="form-group">
							 <form:hidden path="id" />
							 <form:hidden path="content" />
							  <form:hidden path="createdDate" />
							   <form:hidden path="createdDate" />
							  <%--  <form:hidden path="users" /> --%>
							   <form:hidden path="status" />
							    <form:hidden path="estimationgRemainingEffortForTester" />
							   <form:hidden path="estimationgEffortForTester" />
							   
							   
								<label>Title</label>
								<form:input path="title" class="form-control" value="${title}" readonly="true"/>
								<form:errors path="title" cssClass="error" />
							</div>
							<div class="form-group">
								<label>Estimate Effort</label>
								<form:input path="estimationgEffortForDeveloper" class="form-control"  value="${estimatedEffort }"/>
								<form:errors path="estimationgEffortForDeveloper" cssClass="error"  />
							</div>
							<div class="form-group">
								<label>Remaining Effort</label>
								<form:input path="estimationgRemainingEffortForDeveloper" class="form-control" value="${remainingEffort }"  />
								<form:errors path="estimationgRemainingEffortForDeveloper" cssClass="error" />
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