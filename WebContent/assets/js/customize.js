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

function deleteSubject(subjectId, content) {
	if (confirm("are you sure want delete this")) {
		$.ajax({
			type : 'POST',
			url : 'subjectadmin/deletesubject?subject.subjectId=' + subjectId,
			dataType : 'text',
			success : function(data) {
				content.remove();
			}
		});
	}
}