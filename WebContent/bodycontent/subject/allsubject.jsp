<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<div class="container">
    <h2 class="text-center">All Subjects</h2>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <a href='<s:url value="/subjectadmin/createsubject"></s:url>'>Add
            Subject</a>
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
                <th>Subject Name</th>
                <th>Description</th>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <th>Delete</th>
                    <th>Edit</th>
                </sec:authorize>
            </tr>
        </thead>
        <tbody>
            <s:if test="listSubjects">
                <s:iterator value="listSubjects">
                    <tr>
                        <s:url action="viewsubjectdetails" var="subjectdetails">
                            <s:param name="subject.subjectId">${subjectId }</s:param>
                        </s:url>
                        <td><a href='${subjectdetails }'>${name }</a></td>
                        <td>${description }</td>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <td><a href="#"
                                onclick="deleteSubject(${subjectId},this.parentNode.parentNode);return false;"><i
                                    class="glyphicon glyphicon-trash deletesubject"></i></a></td>
                            <s:url action="updatesubject" var="updateSubject">
                                <s:param name="subject.subjectId">${subjectId }</s:param>
                            </s:url>
                            <td><a href="${updateSubject }"><i
                                    class="glyphicon glyphicon-edit"></i></a></td>
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
