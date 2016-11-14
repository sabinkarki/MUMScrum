<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MUMScrum LogIn</title>
<script
	src="${pageContext.request.contextPath }/resources/js/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/bootstrap/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/bootstrap/css/bootstrap-theme.css">


<script
	src="${pageContext.request.contextPath }/resources/bootstrap-3.3.6-dist/js/bootstrap.js"></script>
<%-- <link type="text/css" rel="stylesheet"
	href="<c:url value='resources/css/style.css'/>" /> --%>
	<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/style1.css" />
</head>
<body>


	<div id="loginModal" class="modal show" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h1 class="text-center">Login</h1>
				</div><!-- modal-header -->
				<div class="modal-body">
					<form class="form col-md-12 center-block form-signin"
						<%-- 			action='<spring:url value="/j_spring_security_check"></spring:url>' --%>
			method="post">

						<div class="form-group">
							<label for="UserName">User Name</label> <input type="text"
								class="form-control" name="j_username" placeholder="username"
								required="required"> <label for="password">
								Password</label> <input type="password" class="form-control"
								name="j_password" placeholder="Password" required="required">
						</div>

						<div class="checkbox pull-left">
							<label> <input type="checkbox"> Remember me
							</label>
						</div>
						<button type="submit" class="btn btn-primary btn-lg btn-block" value="Login">Sign
							in</button>
				
				</form>
			</div><!-- modal body -->
			<div class="modal-footer">
				<div class="col-md-12">
					<button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
				</div>
			</div><!-- modal-footer -->
		</div><!-- modal-content -->
	</div><!-- modal-dialog -->
	</div><!-- modal show -->
</body>
</html>




