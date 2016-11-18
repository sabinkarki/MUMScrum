<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- jQuery -->
<script src="<c:url value="/resources/js/jquery.js" />"></script>

<!-- Bootstrap Core JavaScript -->
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/mumscrum.js" />"></script>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://uxsolutions.github.io/bootstrap-datepicker/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>


<script>
	$(function() {
		var date = new Date();
		date.setDate(date.getDate()-1);
		$(".datepicker").datepicker();
		$('.mumscrumDateField').datepicker({
		    autoclose: true,
		    format:"yyyy-mm-dd",
		    startDate: date,
		    todayHighlight: true,
		});

		$("#productListDropdown").load("/mumscrum/product/list",
				function(data, status) {
					console.log(data);

				});

	});
</script>
