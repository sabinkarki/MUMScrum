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
<title>Insert title here</title>
</head>
<body>

	<h:header />
</head>
<body>

	<div id="page-wrapper">
		<div class="container-fluid">
			<!-- Page Heading -->
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						<c:choose>
							<c:when test="${edit}">
								Edit Sprint
							</c:when>
							<c:otherwise>
								Add Sprint
							</c:otherwise>
						</c:choose>
					</h1>
				</div>
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-6">
					<form:form role="form" method="POST" modelAttribute="sprint"
						id="sprint">
						<table>
							<tr>
								<td><form:label path="title">Title</form:label></td>
								<td>:</td>
								<td><form:input id="title" path="title" required="required" /></td>
							</tr>
							<tr>
								<td><form:label path="startDate">Start Date</form:label></td>
								<td>:</td>
								<td><form:input id="startDate" path="startDate" required="required"  class="datepicker" value="${startDate }" /></td>
							</tr>
							<tr>
								<td><form:label path="endDate">End Date</form:label></td>
								<td>:</td>
								<td><form:input id="endDate" path="endDate"	required="required" class="datepicker" value="${endDate }"  /></td>
							</tr>
							 <font color="red">${dateError}</font> 
						</table>

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