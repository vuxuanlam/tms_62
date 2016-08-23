<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container">
	<h2>All admin</h2>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Id</th>
				<th>name</th>
				<th>Email</th>
				<th>Password</th>
				<th>Create at</th>
				<th>Update at</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="listAccounts">
				<s:if test="role == 1">
					<tr>
						<td>${userId}</td>
						<td>${name}</td>
						<td>${email}</td>
						<td>${password}</td>
						<td>${createAt}</td>
						<s:if test="%{updateAt==null}">
							<td>N/A</td>
						</s:if>
						<s:elseif test="%{updateAt!=null}">
							<td>${updateAt}</td>
						</s:elseif>
					</tr>
				</s:if>
			</s:iterator>
		</tbody>
	</table>

	<h2>All user</h2>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Id</th>
				<th>name</th>
				<th>Email</th>
				<th>Password</th>
				<th>Create at</th>
				<th>Update at</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="listAccounts">
				<s:if test="role != 1">
					<tr>
						<td>${userId}</td>
						<td>${name}</td>
						<td>${email}</td>
						<td>${password}</td>
						<td>${createAt}</td>
						<td>${updateAt}</td>
					</tr>
				</s:if>
			</s:iterator>
		</tbody>
	</table>

</div>