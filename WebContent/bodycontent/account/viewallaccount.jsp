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
                </tr>
            </s:iterator>
        </tbody>
    </table>
    <!-- Activities -->
    <h2 class="text-center">Activities</h2>
    <div class="row listactivities">
        <s:iterator value="listActivities">
            <div class="row">
                <div class="col-md-6">${description }</div>
                <div class="col-md-3">
                    By <span class="text-primary">${user.name }</span>
                </div>
                <div class="col-md-3">
                    At <span class="text-info"><s:date name="createAt" /></span>
                </div>
            </div>
        </s:iterator>
    </div>
</div>
