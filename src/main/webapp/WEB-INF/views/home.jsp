<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h"%>

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
					<h1 class="page-header">Welcome to MUMScrum</h1>

				</div>
			</div>
			<!-- /.row -->


			<div class="row">
				<div class="col-lg-12">


					<div class="alert alert-info" role="alert">
						No product added yet. <a href="<c:url value='/product/new' />">Add
							product </a>|<a href="<c:url value='/register' />">Register </a>
							|<a href="<c:url value='/developerUserStoryEffort' />">DevelopmentEffort </a>
							
					</div>
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
