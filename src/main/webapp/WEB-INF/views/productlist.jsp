<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    

				
<c:forEach var="product" items="${productList}">
	<li><a href="${pageContext.request.contextPath}/product/${product.getId()}">${product.getName()}</a>
	<small style="margin-left: 25px;">${product.getStartDate()}</small>
	</li>
	<li class="divider"></li>

</c:forEach>
<li><a href="<c:url value='/product/new'/>"><i class="fa fa-fw fa-envelope"></i> Create product</a></li>


