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
            </tr>
        </thead>
        <tbody>
            <s:iterator value="listAccounts">
                <tr>
                    <td>${name }</td>
                    <td>${email }</td>
                    <td><s:if test="role">
                            <td class="text-danger">Supervior</td>
                        </s:if> <s:else>
                            <td>Member</td>
                        </s:else></td>
                    <td>${createAt }</td>
                </tr>
            </s:iterator>
        </tbody>
    </table>
</div>
