<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserList</title>
</head>
<body>
	<h1>
		<a href="/mumscrum/">Home</a>
	</h1>

	<div class="timer">
		<c:if test="${success eq true }">
			<div>Registration successfully</div>
		</c:if>
	</div>
	<div class="timer">
		<c:if test="${update eq true }">
			<div>User Update successfully</div>
		</c:if>
	</div>
	<table>
		<tr>
			<th>Id</th>
			<th>UserName</th>
			<th>Email Address</th>
			<th>SSN</th>
			<th>Status</th>
			<th>Role</th>
			<th>Action</th>
		</tr>
		<tbody id="list">
			<c:forEach items="${users}" var="user" varStatus="count" >
				<tr>
				     <td>${count.count}</td>
					<td>${user.username}</td>
					<td>${user.email}</td>
					<td>${user.ssn}</td>
					<td>${user.status}</td>
					<td>${user.role}</td>
					<td><a href="/mumscrum/edit/${user.id}">Edit</a>|<a
						href="/mumscrum/delete/${user.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
		setTimeout(function() {
			$('.timer').fadeOut('fast');
		}, 2000);
	</script>

</body>
</html>