<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container">

	<h3 class="text-center">Edit Course</h3>
	<div class="row text-center">
		<s:if test="hasActionErrors()">
			<div class="alert alert-danger" role="alert">
				<s:actionerror />
			</div>
		</s:if>
		<s:if test="hasActionMessages()">
			<div class="alert alert-info" role="alert">
				<s:actionmessage />
			</div>
		</s:if>
	</div>
	<div class="col-md-5 col-md-offset-3">
		<s:form class="form-horizontal" method="POST"
			action="/courseadmin/updatecourse?update=true">
			<input type="hidden" name="currentCourse.courseId"
				value="${currentCourse.courseId }">
			<div class="form-group">
				<label for="coursename">Name</label> <input type="text"
					class="form-control" id="coursename" name="currentCourse.name"
					value="${currentCourse.name }">
			</div>
			<div>

				<label for="coursedescription">Description</label> <input type="text"
					class="form-control" id="coursedescription" name="currentCourse.description"
					value="${currentCourse.description }">
			</div>
			<div class="form-group">
				<label for="startdate">Start date</label> <input type="date"
					class="form-control" id="startdate" name="currentCourse.startDate"
					value="${currentCourse.startDate }">
			</div>
			<div class="form-group">
				<label for="enddate">End date</label> <input type="date"
					class="form-control" id="enddate" name="currentCourse.endDate"
					value="${currentCourse.endDate }">
			</div>
			<br>
			<br>
			<div class="form-group">

				<button type="submit" class="btn btn-primary btn-block">Update</button>
			</div>

		</s:form>
	</div>
</div>
