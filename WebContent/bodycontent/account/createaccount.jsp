<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container">
	<form class="form-inline" method="POST" action="createaccount">
		<table class="table">
			<tr>
				<td><label for="exampleInputName2">Name</label></td>
				<td><input type="text" class="form-control"
					id="exampleInputName2" placeholder="Test" name="userTemp.name"></td>
			</tr>
			<tr>
				<td><label for="exampleInputEmail2">Email</label></td>
				<td><input type="email" class="form-control"
					id="exampleInputEmail2" name="userTemp.email"
					placeholder="test@example.com"></td>
			</tr>
			<tr>
				<td><label for="exampleInput">Password</label></td>
				<td><input type="password" class="form-control"
					id="exampleInputName2" name="userTemp.password"
					placeholder="12345678"></td>
			</tr>
			<tr>
				<td>Permission</td>
				<td><select class="custom-select" name="userTemp.role">
						<option selected>Select permission</option>
						<option value="0">User</option>
						<option value="1">Addmin</option>
						<option value="2">Supper User</option>
				</select></td>
			</tr>
			<tr>
				<s:submit cssClass="btn btn-primary" />
			</tr>
		</table>
	</form>
</div>
