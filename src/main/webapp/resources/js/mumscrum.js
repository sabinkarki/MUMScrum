$(document).ready(function(){
	var locationHash = window.location.hash;
	$('.sidebarElements').removeClass('active');
	$(locationHash+"Sidebar").addClass('active');
	if(locationHash=="")
		$("#productSidebar").addClass('active');
	
	
	$(".moveToRelease").bind('click',function(){
		var this1 = $(this);
		 $.get("/mumscrum/movetorelease/userstory/"+$(this).data('storyid')+"/release/"+$(this).data('releaseid'), function(data, status){
		        this1.text("Moved");
		        setTimeout(function(){
			        this1.parent().parent().hide();
		        },500)

		    });
		

	})
		

});