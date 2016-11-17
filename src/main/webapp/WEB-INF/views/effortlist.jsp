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
								<thead>
									<tr>
										<th>User Stories</th>
										
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><c:forEach var="userstory" items="${userstoryList}">
												<li><a
													href="${pageContext.request.contextPath}/userstoryEffort/${userstory.getId()}">${userstory.getTitle()}</a>
													<%-- <small style="margin-left: 25px;">${product.getStartDate()}</small> --%>
												</li>
												

												<%-- <li><a href="<c:url value='/product/new'/>"><i class="fa fa-fw fa-envelope"></i> Create product</a></li> --%>


											</c:forEach></td>
										
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
