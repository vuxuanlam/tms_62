<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<div class="container">
    <h2 class="text-center">All Courses</h2>
    <table class="table">
        <thead>
            <tr>
                <th>Course Name</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Start/Finish</th>
            </tr>
        </thead>
        <tbody>
            <s:if test="listCourses">
                <s:iterator value="listCourses">
                    <tr>
                        <s:url action="viewcoursedetails" var="coursedetailslink">
                            <s:param name="currentCourse.courseId">${courseId }</s:param>
                        </s:url>
                        <td><a href="${coursedetailslink }">${name }</a></td>
                        <td><s:date name="startDate " format="dd/MM/yyyy" /></td>
                        <td><s:date name="endDate " format="dd/MM/yyyy" /></td>

                        <!-- Admin, supervior start, finish course -->
                        <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_SUPERVIOR')">
                            <td><s:if test="status == 1">
                                    <s:url action="finishcourse" var="finishcourse">
                                        <s:param name="currentCourse.courseId">${courseId }</s:param>
                                    </s:url>
                                    <a href="${finishcourse }" class="btn btn-danger">CLOSE</a>
                                </s:if> <s:elseif test="status == 0">
                                    <s:url action="startcourse" var="startcourse">
                                        <s:param name="currentCourse.courseId">${courseId }</s:param>
                                    </s:url>
                                    <a href="${startcourse }" class="btn btn-primary">START</a>
                                </s:elseif> <s:elseif test="status == 2">
                                    <button class="btn btn-warning disabled" type="button">FINISHED</button>
                                </s:elseif></td>
                        </sec:authorize>

                        <!-- User view status of course -->
                        <sec:authorize access="hasRole('ROLE_USER')">
                            <td><s:if test="status == 1">
                                    <a href="#" class="btn btn-primary disabled" role="button">OPEN</a>
                                </s:if> <s:elseif test="status == 2">
                                    <a href="#" class="btn btn-warning disabled" role="button">FINISHED</a>
                                </s:elseif> <s:elseif test="status == 0 ">
                                    <a href="#" class="btn btn-danger disabled" role="button">CLOSE</a>
                                </s:elseif></td>
                        </sec:authorize>
                    </tr>
                </s:iterator>
            </s:if>
        </tbody>
    </table>
</div>
