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

					<div id="wrapper">

						<h:sidebar />

						<div id="page-wrapper">

							<div class="container-fluid">

								<!-- Page Heading -->
								<div class="row">
									<div class="col-lg-12">


										<h1 class="page-header">
											Dashboard <small>Add UserStory</small>
										</h1>
										<form:form role="form" method="POST"
											modelAttribute="userstory" id="userstory">
											<%-- <form:hidden path="id" /> --%>
											<table>
												<tr>
													<td><form:label path="id">id</form:label></td>
													<td>:</td>
													<td><form:input id="id" path="id" required="required" /></td>
												</tr>
												<tr>
													<td><form:label path="title">Title</form:label></td>
													<td>:</td>
													<td><form:input id="title" path="title"
															required="required" /></td>
												</tr>
												<tr>
													<td><form:label path="content">content</form:label></td>
													<td>:</td>
													<td><form:input id="content" path="content"
															required="required" /></td>
												</tr>
												<tr>
													<td><form:label path="createdDate">Created Date</form:label></td>
													<td>:</td>
													<td><form:input id="createdDate" path="createdDate"
															required="required" class="datepicker" value="${today}" /></td>
												</tr>

												<tr>
													<td><form:label path="users">Developer</form:label></td>
													<td>:</td>
													<td><select name='users0'>
															<c:forEach items="${developerMap}" var="yourEntry">
																<option value="${yourEntry.key}" id="${yourEntry.value}">${yourEntry.value}</option>
															</c:forEach>
													</select></td>
												</tr>
												<tr>
													<td><form:label path="users">Tester</form:label></td>
													<td>:</td>
													<td><select name='users1'>
															<c:forEach items="${testerMap}" var="yourEntry">
																<option value="${yourEntry.key}" id="${yourEntry.value}">${yourEntry.value}</option>
															</c:forEach>
													</select></td>
												</tr>
												<tr>
													<td><form:label path="status">Status</form:label></td>
													<td>:</td>
													<td><form:input id="status" path="status"
															required="required" /></td>
												</tr>
												<tr>
													<td><form:label path="estimationgEffortForDeveloper">Estd. Dev. Effort</form:label></td>
													<td>:</td>
													<td><form:input id="estimationgEffortForDeveloper"
															path="estimationgEffortForDeveloper" required="required" /></td>
												</tr>
												<tr>
													<td><form:label path="estimationgEffortForTester">Estd. Test. Effort</form:label></td>
													<td>:</td>
													<td><form:input id="estimationgEffortForTester"
															path="estimationgEffortForTester" required="required" /></td>
												</tr>
												<tr>
													<td><form:label
															path="estimationgRemainingEffortForDeveloper">Remaining. Dev. Effort</form:label></td>
													<td>:</td>
													<td><form:input
															id="estimationgRemainingEffortForDeveloper"
															path="estimationgRemainingEffortForDeveloper"
															required="required" /></td>
												</tr>
												<tr>
													<td><form:label
															path="estimationgRemainingEffortForTester">Estd. Test. Effort</form:label></td>
													<td>:</td>
													<td><form:input
															id="estimationgRemainingEffortForTester"
															path="estimationgRemainingEffortForTester"
															required="required" /></td>
												</tr>
												<tr colspan="3">
													<td><input type="submit" value="Save" " /></td>
												</tr>
											</table>
										</form:form>

									</div>
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