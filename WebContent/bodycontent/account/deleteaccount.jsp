<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container">
    <h2 class="text-center">Account</h2>
    <table class="table">
        <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Role</th>
                <th>Join Date</th>
                <th>Join Days</th>
                <th>Delete</th>
                <th>Edit</th>
            </tr>
        </thead>
        <tbody>
            <s:iterator value="listAccounts">
                <tr>
                    <td>${name }</td>
                    <td>${email }</td>
                    <s:if test="role == 1">
                        <td class="text-info">Supervior</td>
                    </s:if>
                    <s:elseif test="role == 2">

                        <td class="text-danger">Admin</td>
                    </s:elseif>
                    <s:else>
                        <td>Member</td>
                    </s:else>
                    <td><s:date name="createAt" format="dd/MM/yyyy" /></td>
                    <td><s:date name="createAt" nice="true" /></td>
                    <s:url var="delete"
                        value='http://localhost:8080/tms_62/accountadmin/deleteaccount'>
                        <s:param name="currentUser.userId">
                            <s:property value="%{userId}" />
                        </s:param>
                    </s:url>
                    <td><s:a href="%{delete}" onclick="myFunction()">
                            <span class="glyphicon glyphicon-trash"
                                aria-hidden="true"></span>
                        </s:a></td>
                    <script>
						function myFunction() {
							confirm("Do you want delete!");
						}
					</script>
                    <td>
                        <form action="accountadmin/editaccount" method="post">
                            <input type="hidden" name="currentUser.userId"
                                value="${userId}" />
                            <div class="form-group">
                                <label>Email address</label> <input type="email"
                                    class="form-control" id="exampleInputEmail1"
                                    placeholder="test@example.com"
                                    name="currentUser.email" value="${email }" />
                            </div>
                            <div class="form-group">
                                <label>Username</label> <input type="text"
                                    class="form-control" placeholder="Test"
                                    name="currentUser.name" value="${name}" />
                            </div>
                            <div class="form-group">
                                <label>Password</label> <input type="password"
                                    class="form-control" placeholder="12345678"
                                    name="currentUser.password"
                                    value="${password}" />
                            </div>
                            <br /> <input type="submit" value="Send edit"
                                class="btn btn-success" />
                        </form>
                    </td>
                </tr>
            </s:iterator>
        </tbody>
    </table>
</div>
