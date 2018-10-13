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

	case 'All Products' :
		$("#listProducts").addClass("active");
		break;

	default :
		$("#listProducts").addClass("active");
		$("#a_"+menu).addClass("active");
		break;
	}
	
});