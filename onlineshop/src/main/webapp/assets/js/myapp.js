$(function() { 
	// solving the active menu problem
	//console.log(menu);
	$("#home").removeClass("active");
	switch(menu)
	{
	case 'About Us' :
		$("#about").addClass("active");
		break;
	
	case 'Contact Us' :
		$("#contact").addClass("active");
		break;

	default :
		$("#home").addClass("active");
		break;
	}
	
});