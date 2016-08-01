<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container">
	<h3>Show all course</h3>
	<table class="table">
		<tr>
			<td>Name course</td>
			<td>Descript</td>
			<td>Action</td>
		</tr>
		<s:iterator value="listCourses">
			<tr>
				<td><s:property value="%{name}" /></td>
				<td><s:property value="%{description}" /></td>
				<s:url var="coursemember"
					value='http://localhost:8080/tms_62/courseuser/viewmembercourse'>
					<s:param name="currentCourse.courseId">
						<s:property value="%{courseId}" />
					</s:param>
				</s:url>
				<td><s:a href="%{coursemember}">View user in course</s:a></td>
			</tr>
		</s:iterator>

	</table>
	<s:if test="{listUsersCourse!=null}">
		<div class="table-responsive">
			<h2>
				Show all member of
				<s:property value="currentCourse.name" />
			</h2>
			<table class="table">
				<thead>
					<tr>
						<th>Name</th>
						<th>Email</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="listUsersCourse">
						<tr>
							<td><s:property value="user.name" /></td>
							<td><s:property value="user.email" /></td>
							<s:if test="{currentCourse.status==true}">
								<td>Learning</td>
							</s:if>
							<s:else>
								<td>Finished</td>
							</s:else>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</s:if>
</div>