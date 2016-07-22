<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<div class="container">
    <h2 class="text-center">All Subjects</h2>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <a href='<s:url value="/subjectadmin/createsubject"></s:url>'>Add Subject</a>
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
                        <td><a
                            href='<s:url value="viewsubjectdetails"></s:url>${subjectId}'>${name }</a></td>
                        <td>${description }</td>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <td><a href="deletesubject${subjectId }"><i
                                    class="glyphicon glyphicon-trash"></i></a></td>
                            <td><a href="updatesubject${subjectId }"><i
                                    class="glyphicon glyphicon-edit"></i></a></td>
                        </sec:authorize>
                    </tr>
                </s:iterator>
            </s:if>
        </tbody>
    </table>
</div>