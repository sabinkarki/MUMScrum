<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-ex1-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="index.html">MUMScrum</a>
	</div>
	<!-- Top Menu Items -->
	<ul class="nav navbar-right top-nav">
		<li class="dropdown">
		<c:choose>
				<c:when test="${not empty selectedProductId}">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"><b
						class="caret"></b> <c:out value="${product.getName()}"></c:out> </a>
				</c:when>
				<c:otherwise>
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"><b
						class="caret"></b>ProductList </a>
				</c:otherwise>
			</c:choose>


			<ul class="dropdown-menu alert-dropdown" id="productListDropdown">

			</ul></li>
		<li class="dropdown"><a href="#" class="dropdown-toggle"
			data-toggle="dropdown"><i class="fa fa-user"></i> <%=session.getAttribute("name")%> <b
				class="caret"></b></a>
			<ul class="dropdown-menu">
				<li><a href="#"><i class="fa fa-fw fa-user"></i> Profile</a></li>


				<li class="divider"></li>
				<li><a href="/mumscrum/logout"><i class="fa fa-fw fa-power-off"></i> Log
						Out</a></li>
			</ul></li>
	</ul>
	<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
	<div class="collapse navbar-collapse navbar-ex1-collapse">
		<ul class="nav navbar-nav side-nav">

			<li id="productSidebar" class="sidebarElements active"><a
				href="<c:url value='/product/${selectedProductId}#product' />"><i
					class="fa fa-fw fa-dashboard"></i>Product Backlog</a></li>
			<li id="releaseSidebar" class="sidebarElements"><a href="<c:url value='/release/product/${selectedProductId}#release' />"><i
					class="fa fa-fw fa-bar-chart-o"></i>Releases</a></li>
			<li id="effortSidebar" class="sidebarElements"><a href="<c:url value='/developerUserStoryEffort' />"><i
					class="fa fa-fw fa-bar-chart-o"></i>Estimate/Update Effort</a></li>

		</ul>
	</div>
	<!-- /.navbar-collapse -->
</nav>
