$(document).ready(function() {
	$("#add-task").click(function() {
		if ($(".task-item:first"))
			$(".task-item:last").clone().insertBefore("#task");
	});
	$("#show").click(function() {
		showpopup();
	});
	$("#close").click(function() {
		hidepopup();
	});

});

function showpopup() {
	$("#changeform").fadeIn();
	$("#changeform").css({
		"visibility" : "visible",
		"display" : "block"
	});
}

function hidepopup() {
	$("#changeform").fadeOut();
	$("#changeform").css({
		"visibility" : "hidden",
		"display" : "none"
	});
}