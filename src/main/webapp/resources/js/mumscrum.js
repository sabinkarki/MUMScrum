$(document).ready(function(){
	var locationHash = window.location.hash;
	$('.sidebarElements').removeClass('active');
	$(locationHash+"Sidebar").addClass('active');
	if(locationHash=="")
		$("#productSidebar").addClass('active');
		

	
})