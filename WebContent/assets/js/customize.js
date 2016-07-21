$(document).ready(function() {
	$("#add-task").click(function() {
		if ($(".task-item:first"))
			$(".task-item:last").clone().insertBefore("#task");
	});
});
