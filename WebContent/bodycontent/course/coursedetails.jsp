<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<div class="container">
    <h2 class="text-center">Course Details</h2>

    <!-- Link back to all course -->
    <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_SUPERVIOR')">
        <a href="/tms_62/courseadmin/viewallcourse">View All Courses</a>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_USER')">
        <a href="/tms_62/courseuser/viewallcourse">View All Courses</a>
    </sec:authorize>

    <!-- Show Error (if have) -->
    <div class="row">
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

        <!-- Courses details -->
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">Courses</div>

                <!-- base infomation -->
                <div class="panel-body">
                    <strong>Course name:</strong> ${currentCourse.name } <br /> <strong>Description:</strong>
                    <p>${currentCourse.description }</p>
                    <b>Start date: </b>
                    <s:date name="currentCourse.startDate " format="dd/MM/yyyy" />
                    <br> <b>End date:</b>
                    <s:date name="currentCourse.endDate " format="dd/MM/yyyy" />

                    <!-- admin, supervior : start, finish course -->
                    <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_SUPERVIOR')">
                        <s:if test="currentCourse.status == 1">
                            <s:url action="finishcourse" var="finishcourse">
                                <s:param name="currentCourse.courseId">${currentCourse.courseId }</s:param>
                            </s:url>
                            <a href="${finishcourse }" class="btn btn-danger pull-right">FINISH</a>
                        </s:if>
                        <s:elseif test="currentCourse.status == 0">
                            <s:url action="startcourse" var="startcourse">
                                <s:param name="currentCourse.courseId">${currentCourse.courseId }</s:param>
                            </s:url>
                            <a href="${startcourse }" class="btn btn-primary pull-right">START</a>
                        </s:elseif>
                        <s:elseif test="currentCourse.status == 2">
                            <button class="btn btn-warning pull-right" type="button"
                                disabled="disabled">FINISHED</button>
                        </s:elseif>
                    </sec:authorize>

                    <!-- user : view status of course -->
                    <sec:authorize access="hasRole('ROLE_USER')">
                        <s:if test="currentCourse.status == 1">
                            <a href="#" class="btn btn-primary disabled pull-right" role="button">OPEN</a>
                        </s:if>
                        <s:elseif test="currentCourse.status == 2">
                            <a href="#" class="btn btn-warning disabled pull-right" role="button">FINISHED</a>
                        </s:elseif>
                        <s:elseif test="currentCourse.status == 0 ">
                            <a href="#" class="btn btn-danger disabled pull-right" role="button">CLOSE</a>
                        </s:elseif>
                    </sec:authorize>
                </div>
            </div>
        </div>

        <!-- Subject, User of course details -->
        <div class="col-md-6">
            <div class="row">

                <!--Subject of Course, subject not of course  -->
                <div class="panel panel-info">
                    <div class="panel-heading">Subjects</div>
                    <div class="panel-body">
                        <s:iterator value="currentCourse.listCoursesSubjects">
                            <div class="row">
                                <div class="col-md-6">${subject.name }</div>
                                <!-- Admin, Supervior remove subject of course -->
                                <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SUPERVIOR')">
                                    <div class="col-md-3">
                                        <s:if test="currentCourse.status == 0">
                                            <a href="#" class="btn btn-danger disabled">CLOSE</a>
                                        </s:if>
                                        <s:if test="status == 0 && currentCourse.status == 1">
                                            <s:url value="/subjectadmin/startsubject"
                                                var="startsubject">
                                                <s:param name="courseSubject.courseSubjectId">${courseSubjectId }</s:param>
                                            </s:url>
                                            <a href="${startsubject }" class="btn btn-primary">Start</a>
                                        </s:if>
                                        <s:if test="currentCourse.status == 1 && status == 1">
                                            <s:url value="/subjectadmin/finishsubject"
                                                var="finishsubject">
                                                <s:param name="courseSubject.courseSubjectId">${courseSubjectId }</s:param>
                                            </s:url>
                                            <a href="${finishsubject }" class="btn btn-danger">Finish</a>
                                        </s:if>
                                        <s:if test="currentCourse.status == 1 && status == 2">
                                            <a href="#" class="disabled btn btn-warning">FINISHED</a>
                                        </s:if>
                                        <s:if test="currentCourse.status == 2">
                                            <a href="#" class="disabled btn btn-warning">FINISHED</a>
                                        </s:if>
                                    </div>
                                    <div class="col-md-3">
                                        <s:if test="currentCourse.status == 2">
                                            <button class="btn btn-warning" type="button"
                                                disabled="disabled">FINISHED</button>
                                        </s:if>
                                        <s:else>
                                            <s:url action="removesubject" var="removesubject">
                                                <s:param name="courseSubject.courseSubjectId">${courseSubjectId }</s:param>
                                            </s:url>
                                            <a href="${removesubject }" class="btn btn-danger">Remove</a>
                                        </s:else>

                                    </div>
                                </sec:authorize>
                            </div>
                        </s:iterator>
                        <hr>
                        <!-- Subject not of course -->
                        <s:iterator value="listSubjectNotOfCourse" var="subject">
                            <div class="row">
                                <div class="col-md-9">${subject.name }</div>
                                <div class="col-md-3">
                                    <s:url var="addSubject" action="addsubject">
                                        <s:param name="subject.subjectId">${subject.subjectId }</s:param>
                                        <s:param name="currentCourse.courseId">${currentCourse.courseId }</s:param>
                                    </s:url>
                                    <sec:authorize
                                        access="hasAnyRole('ROLE_ADMIN','ROLE_SUPERVIOR')">
                                        <s:if test="currentCourse.status == 2">
                                            <button class="btn btn-warning" type="button"
                                                disabled="disabled">FINISHED</button>
                                        </s:if>
                                        <s:else>
                                            <a href="${addSubject }" class="btn btn-primary">Add</a>
                                        </s:else>
                                    </sec:authorize>
                                </div>
                            </div>
                        </s:iterator>
                    </div>
                </div>
            </div>

            <!-- User of course, not of course -->
            <div class="row">
                <div class="panel panel-info">
                    <div class="panel-heading">Users of Course</div>
                    <div class="panel-body">
                        <s:iterator value="currentCourse.listUsersCourses" var="userCourse">
                            <div class="row">
                                <div class="col-md-4">${userCourse.user.name }</div>
                                <div class="col-md-4">
                                    <s:set value="userCourse.user" var="user">
                                    </s:set>
                                    <s:if test="user.role == 1">
                                        <span class="text-info">Supervior</span>
                                    </s:if>
                                    <s:else>
                                        Member
                                    </s:else>
                                </div>
                                <sec:authorize access="hasRole('ROLE_ADMIN')">
                                    <div class="col-md-4">
                                        <s:url action="removeuserfromcourse"
                                            var="removeuserfromcourse">
                                            <s:param name="currentCourse.courseId">${currentCourse.courseId }</s:param>
                                            <s:param name="user.userId">${user.userId }</s:param>
                                        </s:url>
                                        <s:if test="currentCourse.status == 2">
                                            <button class="btn btn-warning" type="button"
                                                disabled="disabled">FINISHED</button>
                                        </s:if>
                                        <s:else>
                                            <a href="${removeuserfromcourse }"
                                                class="btn btn-danger">Remove</a>
                                        </s:else>
                                    </div>
                                </sec:authorize>
                            </div>
                        </s:iterator>
                        <hr>
                        <s:iterator value="listUsersNotOfCourse">
                            <div class="row">
                                <div class="col-md-4">${name }</div>
                                <div class="col-md-4">
                                    <s:if test="role == 1">
                                        <span class="text-info">Supervior</span>
                                    </s:if>
                                    <s:else>
                                Member
                                </s:else>
                                </div>
                                <sec:authorize access="hasRole('ROLE_ADMIN')">
                                    <s:url action="addusertocourse" var="addusertocourse">
                                        <s:param name="currentCourse.courseId">${currentCourse.courseId }</s:param>
                                        <s:param name="user.userId">${userId }</s:param>
                                    </s:url>
                                    <div class="col-md-4">
                                        <s:if test="currentCourse.status == 2">
                                            <button class="btn btn-warning" type="button"
                                                disabled="disabled">FINISHED</button>
                                        </s:if>
                                        <s:else>
                                            <a href="${addusertocourse }" class="btn btn-primary">Add</a>
                                        </s:else>
                                    </div>
                                </sec:authorize>
                            </div>
                        </s:iterator>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
