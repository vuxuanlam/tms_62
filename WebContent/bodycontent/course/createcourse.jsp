<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container">
	<div align="center">

		<s:form method="post" action="/courseadmin/createcourse">
			<table class="table table-striped" >
				<tbody>
					<tr>
						<td colspan="2" align="center"><h2>Creat Course</h2></td>
					</tr>
					<tr>
						<td>Course Name:</td>
						<td><input type="text" name="currentCourse.name" /></td>
					</tr>
					<tr>
						<td>Course Description:</td>
						<td><input type="text" name="currentCourse.description" /></td>
					</tr>
					<tr>
						<td>Start Date:</td>
						<td><input type="date" name="currentCourse.startDate"
							required="required" /></td>
					</tr>
					<tr>
						<td>End Date:</td>
						<td><input type="date" name="currentCourse.endDate"
							required="required" /></td>
					</tr>
					<s:if test="listSubjects">
						<tr>
							<s:iterator value="listSubjects">
								<td><input type="checkbox" name="subject.subjectId"
									value="${subjectId }" /> ${name }</td>
							</s:iterator>
						</tr>
					</s:if>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Create" /></td>
					</tr>
				</tbody>
			</table>
		</s:form>

	</div>
</div>