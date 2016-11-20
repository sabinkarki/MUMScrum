<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="<c:url value="/resources/js/jquery.js" />"></script>
<script src="<c:url value="/resources/js/register.js" />"></script>

<html>
<head>
<title>Home</title>
</head>
<body>
	<div align="center">
		<div>
			<c:if test="${errMsg != null}">
			${errMsg}
		</c:if>
		</div>
		<form:form modelAttribute="userForm" id="registerForm" method="POST">
			<table border="1">
				<tr>
					<td colspan="2" align="center"><h2>Registration</h2></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><form:input path="name" />
						<form:errors path="name" cssStyle="color: red" /></td>
				</tr>
				<tr>
					<td>User Name:</td>
					<td><form:input path="username" />
						<form:errors path="username" cssStyle="color: red" /></td>
				</tr>
				<tr>
					<td>E-mail:</td>
					<td><form:input path="email" />
						<form:errors path="email" cssStyle="color: red" /></td>
				</tr>
				<tr>
					<td>SSN:</td>
					<td><form:input path="ssn" />
						<form:errors path="ssn" cssStyle="color: red" /></td>
				</tr>
				<tr>
					<td>Profession:</td>
					<td><form:select path="role">
							<form:options items="${lstOfRoles}" />
						</form:select></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Register" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>
