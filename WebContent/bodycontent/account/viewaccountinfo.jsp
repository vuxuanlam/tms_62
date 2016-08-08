<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container">
    <h2>Information user</h2>
    <table class="table">
        <thead>
            <tr>
                <th>Userame</th>
                <th>Password</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><s:property value="currentUser.name" /></td>
                <td><s:property value="currentUser.password" /></td>
                <td><s:property value="currentUser.email" /></td>
            </tr>
        </tbody>
    </table>
    <input type="button" id="show" value="Show Login">

    <div id="changeform">

        <form method="post" action="edit">
            <p>If you want to change your infomation</p>
            <input type="hidden" name="user.userId" value="${currentUser.userId }" /> <input type="hidden"
                name="user.email" value="${currentUser.email }" /> <input type="hidden" name="user.role"
                value="${currentUser.role }" /> <input type="text" id="name" placeholder="Username"
                name="user.name" value="${currentUser.name }"> <input type="password" id="password"
                name="user.password" value="${currentUser.password }"> <input type="submit"
                id="dochange" value="Change"> <input type="button" id="close" value="Close" />
        </form>

    </div>
</div>