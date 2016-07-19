<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container">
    <h2 class="text-center">All Courses</h2>
    <table class="table">
        <thead>
            <tr>
                <th>Course Name</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <s:if test="listCourses">
                <s:iterator value="listCourses">
                    <tr>
                        <td>${name }</td>
                        <td>${startDate }</td>
                        <td>${endDate }</td>
                        <td><s:if test="status">
                                <span class="text-danger">Active</span>
                            </s:if> <s:else>
                        Closed
                        </s:else></td>
                    </tr>
                </s:iterator>
            </s:if>

        </tbody>
    </table>
</div>
