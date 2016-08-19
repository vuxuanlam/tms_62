<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<div class="container">
    <h2 class="text-center">All Courses</h2>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <a href='<s:url value="/courseadmin/createcourse"></s:url>'>Add
            Course</a>
    </sec:authorize>
    <div class="row text-center">
        <s:if test="hasActionErrors()">
            <div class="alert alert-danger" role="alert">
                <s:actionerror />
            </div>
        </s:if>
        <s:if test="hasActionMessages()">
            <div class="alert alert-info" role="alert">
                <s:actionmessage />
            </div>
        </s:if>
    </div>
    <table class="table">
        <thead>
            <tr>
                <th>Course Name</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Status</th>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <th>Delete</th>
                    <th>Edit</th>
                </sec:authorize>
            </tr>
        </thead>
        <tbody>
            <s:if test="listCourses">

                <s:iterator value="listCourses">
                    <tr>
                        <s:url action="viewcoursedetails"
                            var="coursedetailslink">
                            <s:param name="currentCourse.courseId">${courseId }</s:param>
                        </s:url>
                        <td><a href="${coursedetailslink }">${name }</a></td>

                        <td>${startDate }</td>
                        <td>${endDate }</td>

                        <!-- Admin, supervior start, finish course -->
                        <sec:authorize
                            access="hasAnyRole('ROLE_ADMIN', 'ROLE_SUPERVIOR')">
                            <td><s:if test="status == 1">
                                    <s:url action="finishcourse"
                                        var="finishcourse">
                                        <s:param name="currentCourse.courseId">${courseId }</s:param>
                                    </s:url>
                                    <a href="${finishcourse }"
                                        class="btn btn-danger">CLOSE</a>
                                </s:if> <s:elseif test="status == 0">
                                    <s:url action="startcourse"
                                        var="startcourse">
                                        <s:param name="currentCourse.courseId">${courseId }</s:param>
                                    </s:url>
                                    <a href="${startcourse }"
                                        class="btn btn-primary">START</a>
                                </s:elseif> <s:elseif test="status == 2">
                                    <button class="btn btn-warning disabled"
                                        type="button">FINISHED</button>
                                </s:elseif></td>
                            <s:url action="deletecourse" var="deleteCourse">
                                <s:param name="currentCourse.courseId">${courseId }</s:param>
                            </s:url>
                            <td><a href="${deleteCourse }"><i
                                    class="glyphicon glyphicon-trash"></i></a></td>
                            <s:url action="updatecourse" var="updateCourse">
                                <s:param name="currentCourse.courseId">${courseId }</s:param>
                            </s:url>
                            <td><a href="${updateCourse }"><i
                                    class="glyphicon glyphicon-edit"></i></a></td>

                        </sec:authorize>

                        <!-- User view status of course -->
                        <sec:authorize access="hasRole('ROLE_USER')">
                            <td><s:if test="status == 1">
                                    <a href="#" class="btn btn-primary disabled"
                                        role="button">OPEN</a>
                                </s:if> <s:elseif test="status == 2">
                                    <a href="#" class="btn btn-warning disabled"
                                        role="button">FINISHED</a>
                                </s:elseif> <s:elseif test="status == 0 ">
                                    <a href="#" class="btn btn-danger disabled"
                                        role="button">CLOSE</a>
                                </s:elseif></td>
                        </sec:authorize>
                    </tr>
                </s:iterator>
            </s:if>
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
